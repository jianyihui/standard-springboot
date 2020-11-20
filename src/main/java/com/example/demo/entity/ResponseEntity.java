package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseEntity implements Serializable {
    private Boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    //外界只可以调用返回实体类的方法，不可以直接创建
    private ResponseEntity(){

    }
    // 通用返回成功
    public static ResponseEntity ok() {
        ResponseEntity r = new ResponseEntity();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    // 通用返回失败，未知错误
    public static ResponseEntity error() {
        ResponseEntity r = new ResponseEntity();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    // 设置结果，形参为结果枚举
    public static ResponseEntity setResult(ResultCodeEnum result) {
        ResponseEntity r = new ResponseEntity();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

    // 自定义返回数据
    public ResponseEntity data(Map<String,Object> map) {
        this.setData(map);
        return this;
    }

    // 通用设置data
    public ResponseEntity data(String key,Object value) {
        this.data.put(key, value);
        return this;
    }

    // 自定义状态信息
    public ResponseEntity message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public ResponseEntity code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 自定义返回结果
    public ResponseEntity success(Boolean success) {
        this.setSuccess(success);
        return this;
    }


}
