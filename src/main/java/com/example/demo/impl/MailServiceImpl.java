package com.example.demo.impl;

import com.example.demo.entity.MailParam;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.ResultCodeEnum;
import com.example.demo.service.MailService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {


    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    //发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;

    @Override
    public ResponseEntity sendEmails(MailParam mailParam) {

        try {
            Object object = new Object();
            String arr = "";
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(InternetAddress.parse(mailParam.getUserEmail()));//发送给谁
            helper.setSubject(mailParam.getMailSubject());//邮件标题
            Map<String, Object> model = new HashMap<>();
            model.put("params", mailParam);
            try {
                Template template = configurer.getConfiguration().getTemplate(mailParam.getMailTemplate());
                try {
                    String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
                    helper.setText(text, true);
                    mailSender.send(mimeMessage);
                } catch (TemplateException e) {
                    return ResponseEntity.setResult(ResultCodeEnum.TEMPLATE_EXCEPT);
                }
            } catch (IOException e) {
                return ResponseEntity.setResult(ResultCodeEnum.IO_EXCEPT);
            }
        } catch (MessagingException e) {
            return ResponseEntity.setResult(ResultCodeEnum.MESSAGE_EXCEPT);
        }

        return ResponseEntity.ok();
    }
}
