package com.lltech.llmall.dao;

import com.lltech.llmall.entity.ShoppingCart;
import com.lltech.llmall.entity.ShoppingCartVO;
import com.lltech.llmall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {
    List<ShoppingCartVO> selectShopcartByUserId(int userId);

    int updataCartNumByCartId(@Param("cartId") int cartId,
                              @Param("cartNum") int cartNum);

    List<ShoppingCartVO> selectShopCartByCids(List<Integer> cids);
}