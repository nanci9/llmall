package com.lltech.llmall.dao;

import com.lltech.llmall.entity.ProductComments;
import com.lltech.llmall.entity.ProductCommentsVO;
import com.lltech.llmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsMapper extends GeneralDAO<ProductComments> {

    List<ProductCommentsVO> selectCommentsByProductId(@Param("productId") String productId,
                                                      @Param("start") int start,
                                                      @Param("limit") int limit);

}