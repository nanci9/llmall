package com.lltech.llmall.service;

import com.lltech.llmall.entity.ShoppingCart;
import com.lltech.llmall.vo.ResultVO;

public interface ShoppingCartService {

    ResultVO addShoppingCart(ShoppingCart cart);

    ResultVO listShoppingcartByUserId(int userId);

    ResultVO updataCartNumByCartId(int cartId,int cartNum);

    ResultVO selectShopCartByCids(String cids);
}
