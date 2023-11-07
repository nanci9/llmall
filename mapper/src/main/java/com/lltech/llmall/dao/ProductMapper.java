package com.lltech.llmall.dao;

import com.lltech.llmall.entity.Product;
import com.lltech.llmall.entity.ProductVO;
import com.lltech.llmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper extends GeneralDAO<Product> {
    List<ProductVO> selectRecommendProducts();

    //查询指定一级下销量最高的6个商品
    List<ProductVO> selectTop6Products(int productId);
}