package com.lltech.llmall.service;

import com.lltech.llmall.vo.ResultVO;

public interface UserAddrService {
    ResultVO listAddrByUserId(int userId);
}
