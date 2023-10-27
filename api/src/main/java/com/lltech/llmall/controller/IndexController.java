package com.lltech.llmall.controller;

import com.lltech.llmall.service.CategoryService;
import com.lltech.llmall.service.IndexService;
import com.lltech.llmall.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "首页管理" ,description = "提供首页数据显示所需要的接口")
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/indeximg")
    @Operation(summary = "首页轮播图接口")
    public ResultVO listIndexImgs(){
        return indexService.listIndexImgs();
    }

    @GetMapping("/category-list")
    @Operation(summary = "商品分类查询接口")
    public ResultVO listCategory(){
        return categoryService.listCategories();
    }

}
