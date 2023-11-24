package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.ProductCommentsMapper;
import com.lltech.llmall.entity.ProductCommentsVO;
import com.lltech.llmall.service.ProductCommentsService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

    @Autowired
    private ProductCommentsMapper productCommentsMapper;
    @Override
    public ResultVO getProductCommentsById(String productId) {
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectCommentsByProductId(productId);
        return new ResultVO(ResStatus.OK,"success",productCommentsVOS);
    }
}
