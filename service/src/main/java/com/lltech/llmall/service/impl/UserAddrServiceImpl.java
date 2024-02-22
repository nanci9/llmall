package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.UserAddrMapper;
import com.lltech.llmall.entity.UserAddr;
import com.lltech.llmall.service.UserAddrService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserAddrServiceImpl implements UserAddrService {

    @Autowired
    private UserAddrMapper userAddrMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResultVO listAddrByUserId(int userId) {

        Example example = new Example(UserAddr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        criteria.andEqualTo("status",1);
        List<UserAddr> userAddrs = userAddrMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK,"success",userAddrs);
    }
}
