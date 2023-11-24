package com.lltech.llmall.service;


import com.lltech.llmall.vo.ResultVO;


public interface ProductService {
    ResultVO listRecommendProducts();

    ResultVO getProductBaseInfo(String productId);

    ResultVO getProductParamsById(String productId);
}
