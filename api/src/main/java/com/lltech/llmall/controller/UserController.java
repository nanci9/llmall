package com.lltech.llmall.controller;

import com.lltech.llmall.entity.Users;
import com.lltech.llmall.service.UserService;
import com.lltech.llmall.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户管理")
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @Operation(summary = "用户登录接口")
    @Parameters({
            @Parameter(name = "username", description = "用户登录的账号", required = true),
            @Parameter(name = "password", description = "用户登录的密码", required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name,
                          @RequestParam(value = "password") String pwd) {
        ResultVO resultVO = userService.checkLogin(name, pwd);
        return resultVO;
    }


    @Operation(summary = "用户注册接口")
    @Parameters({
            @Parameter(name = "username", description = "用户注册账号", required = true),
            @Parameter(name = "password", description = "用户注册密码", required = true)
    })
    @PostMapping("/regist")
    public ResultVO register(@RequestBody Users users) {

        ResultVO resultVO = userService.userResgit(users.getUsername(), users.getPassword());
        return resultVO;

    }
}
