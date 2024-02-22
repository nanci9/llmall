package com.lltech.llmall.controller;

import com.lltech.llmall.service.UserAddrService;
import com.lltech.llmall.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tag(name = "地址管理")
@RequestMapping("/useraddr")
public class UserAddrController {
    @Autowired
    private UserAddrService userAddrService;

    @Operation(summary = "地址选择接口")
    @GetMapping("/list")
    @Parameter(name = "userId", description = "用户ID", required = true)
    public ResultVO listUserAddrByUserId(int userId, @RequestHeader String token){
        return userAddrService.listAddrByUserId(userId);
    }
}
