package com.lltech.llmall.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lltech.llmall.dao.UsersMapper;
import com.lltech.llmall.entity.Users;
import com.lltech.llmall.service.UserService;
import com.lltech.llmall.utils.MD5Utils;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional
    public ResultVO userResgit(String name, String pwd) {
        synchronized (this) {

            //根据用户查询，用户是否被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", name);
            List<Users> users = usersMapper.selectByExample(example);

            //没被注册的话进行保存操作
            if (users.size() == 0) {
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user);
                if (i > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功！", user);
                } else {
                    return new ResultVO(ResStatus.NO, "注册失败！", null);
                }
            } else {
                return new ResultVO(ResStatus.NO, "用户名已存在！", null);
            }
        }

    }

    @Override
    public ResultVO checkLogin(String name, String pwd) {

        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> users = usersMapper.selectByExample(example);

        if (users.size() == 0) {
            return new ResultVO(ResStatus.NO, "用户名不存在！", null);
        } else {
            String md5Pwd = MD5Utils.md5(pwd);
            if (md5Pwd.equals(users.get(0).getPassword())) {
                //jwt生成token
                HashMap<String, Object> map = new HashMap<>();
                String token = JWT.create().
                        withClaim("username", name)
                        .withJWTId(users.get(0).getUserId() + "")
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .sign(Algorithm.HMAC256("linlian666"));

                return new ResultVO(ResStatus.OK, token, users.get(0));
            } else {
                return new ResultVO(ResStatus.NO, "密码错误！", null);
            }
        }
    }

}
