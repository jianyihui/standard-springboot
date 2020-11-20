package com.example.demo.service;

import com.example.demo.entity.MailParam;
import com.example.demo.entity.ResponseEntity;

public interface MailService {

    ResponseEntity sendEmails(MailParam mailParam);
}
