package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.IndexImgMapper;
import com.lltech.llmall.entity.IndexImg;
import com.lltech.llmall.service.IndexService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexImgMapper indexImgMapper;
    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
        if (indexImgs.size() == 0){
            return new ResultVO(ResStatus.NO,"fail",null);
        }else {
            return new ResultVO(ResStatus.OK,"success",indexImgs);
        }
    }
}
