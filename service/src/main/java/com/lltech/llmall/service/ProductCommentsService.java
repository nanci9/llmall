package com.lltech.llmall.service;

import com.lltech.llmall.vo.ResultVO;

public interface ProductCommentsService {
    ResultVO getProductCommentsById(String productId,int pageNum,int limit);

    ResultVO getCommentsCountById(String productId);
}
