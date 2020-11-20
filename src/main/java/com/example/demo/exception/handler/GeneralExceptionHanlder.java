package com.example.demo.exception.handler;


import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.ResultCodeEnum;
import com.example.demo.exception.GeneralException;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import java.io.IOException;

@RestControllerAdvice
public class GeneralExceptionHanlder extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {GeneralException.class})
    @ResponseBody
    ResponseEntity generalExceptionHanlder(GeneralException e){
        return ResponseEntity.error().message(e.getMessage()).code(e.getCode());
    }

    /**-------- 通用异常处理方法 --------**/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity error(Exception e) {
        return ResponseEntity.error();    // 通用异常结果
    }

    /**-------- 指定异常处理方法 --------**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity error(NullPointerException e) {
        return ResponseEntity.setResult(ResultCodeEnum.NULL_POINT);
    }
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public ResponseEntity error(IOException e) {
        return ResponseEntity.setResult(ResultCodeEnum.IO_EXCEPT);
    }

    @ExceptionHandler(MessagingException.class)
    @ResponseBody
    public ResponseEntity error(MessagingException e) {
        return ResponseEntity.setResult(ResultCodeEnum.MESSAGE_EXCEPT);
    }
    @ExceptionHandler(TemplateException.class)
    @ResponseBody
    public ResponseEntity error(TemplateException e) {
        return ResponseEntity.setResult(ResultCodeEnum.TEMPLATE_EXCEPT);
    }



}
