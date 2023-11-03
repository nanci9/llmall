package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.ProductMapper;
import com.lltech.llmall.entity.ProductVO;
import com.lltech.llmall.service.ProductService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        return new ResultVO(ResStatus.OK,"success",productVOS);
    }
}
