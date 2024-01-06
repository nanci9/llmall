package com.lltech.llmall.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lltech.llmall.vo.ResStatus;
import com.lltech.llmall.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Tag(name = "购物车管理", description = "提供购物车业务相关接口")
public class ShopcartController {

    @GetMapping("/list")
    @Operation(summary = "购物车列表接口")
    @Parameter(name = "token", description = "授权令牌", required = true)
    public ResultVO listCarts(@RequestHeader("token") String token) {
        System.out.println(token);
        if (token == null) {
            return new ResultVO(ResStatus.NO, "请先登录", null);
        } else {
            // 校验token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("linlian666")).build();
            try {
                DecodedJWT verify = jwtVerifier.verify(token);
                String subject = verify.getSubject();
                return new ResultVO(ResStatus.OK, "success", null);
            } catch (Exception e) {
                return new ResultVO(ResStatus.NO, "登录失效，请重新登陆", null);
            }
        }

    }
}
