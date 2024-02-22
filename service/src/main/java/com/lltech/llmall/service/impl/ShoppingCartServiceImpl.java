package com.lltech.llmall.service.impl;

import com.lltech.llmall.dao.ShoppingCartMapper;
import com.lltech.llmall.entity.ShoppingCart;
import com.lltech.llmall.entity.ShoppingCartVO;
import com.lltech.llmall.service.ShoppingCartService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public ResultVO addShoppingCart(ShoppingCart cart) {
        cart.setCartTime(sdf.format(new Date()));
        int i = shoppingCartMapper.insert(cart);
        if (i > 0) {
            return new ResultVO(ResStatus.OK, "success", null);
        } else {
            return new ResultVO(ResStatus.NO, "faild", null);
        }
    }

    @Override
    public ResultVO listShoppingcartByUserId(int userId) {
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopcartByUserId(userId);
        return new ResultVO(ResStatus.OK, "success", list);
    }

    @Override
    public ResultVO updataCartNumByCartId(int cartId, int cartNum) {
        int i = shoppingCartMapper.updataCartNumByCartId(cartId, cartNum);
        if (i > 0) {
            return new ResultVO(ResStatus.OK, "updata success", null);
        } else {
            return new ResultVO(ResStatus.NO, "updata fail", null);
        }
    }

    @Override
    public ResultVO selectShopCartByCids(String cids) {
        String[] split = cids.split(",");
        List<Integer> cartIds = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            cartIds.add(Integer.parseInt(split[i]));
        }
        List<ShoppingCartVO> list = shoppingCartMapper.selectShopCartByCids(cartIds);
        return new ResultVO(ResStatus.OK,"success",list);
    }
}
