package com.lltech.llmall.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lltech.llmall.entity.ShoppingCart;
import com.lltech.llmall.service.ShoppingCartService;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Tag(name = "购物车管理", description = "提供购物车业务相关接口")
public class ShopcartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Operation(summary = "添加购物车接口")
    @PostMapping("/add")
    public ResultVO addShoppingCart(@RequestBody ShoppingCart cart,@RequestHeader("token") String token){
        return shoppingCartService.addShoppingCart(cart);
    }

    @Operation(summary = "购物车列表接口")
    @GetMapping("/list")
    @Parameter(name = "userId", description = "用户ID", required = true)
    public ResultVO listShoppingcart(Integer userId,@RequestHeader("token") String token){
        return shoppingCartService.listShoppingcartByUserId(userId);
    }

    @Operation(summary = "购物车修改接口")
    @PutMapping("/updata/{cid}/{cnum}")
    public ResultVO updataCartNum(@PathVariable("cid")Integer cartId,
                                  @PathVariable("cnum")Integer cartNum,
                                  @RequestHeader("token")String token){
        return shoppingCartService.updataCartNumByCartId(cartId,cartNum);
    }

    @Operation(summary = "购物车结算选中接口")
    @GetMapping("/listcids")
    @Parameter(name = "cids", description = "选择的购物车记录的id", required = true )
    public ResultVO selectCartByCids(String cids,@RequestHeader("token") String token){
        return shoppingCartService.selectShopCartByCids(cids);
    }

}
