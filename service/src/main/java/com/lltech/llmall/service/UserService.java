package com.lltech.llmall.service;

import com.lltech.llmall.vo.ResultVO;

public interface UserService {

    //用户注册
     ResultVO userResgit(String username , String pwd);

    //用户登录
     ResultVO checkLogin(String username , String pwd);
}
