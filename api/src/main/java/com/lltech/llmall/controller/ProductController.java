package com.lltech.llmall.controller;

import com.lltech.llmall.service.ProductCommentsService;
import com.lltech.llmall.service.ProductService;
import com.lltech.llmall.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "商品管理" ,description = "提供商品信息相关的接口")
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCommentsService productCommentsService;

    @GetMapping("/detail-info/{pid}")
    @Operation(summary = "商品基本信息查询接口")
    public ResultVO getProductBasicInfo(@PathVariable("pid") String pid){
        return productService.getProductBaseInfo(pid);
    }

    @GetMapping("/detail-params/{pid}")
    @Operation(summary = "商品参数信息查询接口")
    public ResultVO getProductParams(@PathVariable("pid") String pid){
        return productService.getProductParamsById(pid);
    }

    @GetMapping("/detail-comments/{pid}")
    @Operation(summary = "商品评论信息查询接口")
    public ResultVO getProductComments(@PathVariable("pid") String pid){
        return productCommentsService.getProductCommentsById(pid);
    }

}
