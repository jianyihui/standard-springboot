package com.example.demo.controller;

import com.example.demo.entity.MailParam;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.service.MailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/mail/")
public class MailController {


    @Autowired
    private MailService mailService;

    @PostMapping(value = "sendEmails")
    @ApiOperation(value = "发送邮件", notes = "发送邮件")
    public ResponseEntity sendEmails(@RequestBody MailParam mailParam, HttpServletRequest request){
        return mailService.sendEmails(mailParam);
    }
}
