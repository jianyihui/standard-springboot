package com.example.demo.exception;

import com.example.demo.entity.ResultCodeEnum;
import lombok.Data;

@Data
public class GeneralException extends RuntimeException{

    private Integer code;

    public GeneralException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GeneralException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "GeneralException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }

}
