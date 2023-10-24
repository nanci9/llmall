package com.lltech.llmall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Schema(name = "ResultVO对象" ,description = "封装接口返回给前端的数据")
public class ResultVO {

    //响应给前端的状态码
    @Schema(description = "响应状态码")
    private int code;

    //响应给前端的提示信息
    @Schema(description = "响应提示信息")
    private String msg;

    //响应给前端的数据
    @Schema(description = "响应数据")
    private Object data;
}
