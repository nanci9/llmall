package com.lltech.llmall.dao;

import com.lltech.llmall.entity.ProductImg;
import com.lltech.llmall.general.GeneralDAO;

import java.util.List;

public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    List<ProductImg> selectProductImgByProductId(int productId);
}