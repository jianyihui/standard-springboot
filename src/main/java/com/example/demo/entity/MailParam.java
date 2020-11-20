package com.example.demo.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Component
public class MailParam implements Serializable{

    @NotBlank(message = "邮件头不能为空")
    private String messageHead;
    @NotBlank(message = "系统名称不能为空")
    private String systemName;
    @NotBlank(message = "验证码不能为空")
    private String origin;
    @NotBlank(message = "收件人邮箱不能为空")
    private String userEmail;
    @NotBlank(message = "邮件主题不能为空")
    private String mailSubject;
    @NotBlank(message = "邮箱模板不能为空")
    private String mailTemplate;


    private MailParam(){

    }

    public static MailParam newInstance() {
        return new MailParam();
    }
    private MailParam(Builder builder){
        messageHead = builder.messageHead;
        systemName = builder.systemName;
        origin = builder.origin;
        userEmail = builder.userEmail;
        mailSubject = builder.mailSubject;
        mailTemplate = builder.mailTemplate;
    }

    public static class Builder{
        private String messageHead;
        private String systemName;
        private String origin;
        private String userEmail;
        private String mailSubject;
        private String mailTemplate;


        public Builder messageHead(String val){
            messageHead = val;
            return this;
        }
        public Builder systemName(String val){
            systemName = val;
            return this;
        }
        public Builder origin(String val){
            origin = val;
            return this;
        }
        public Builder userEmail(String val){
            userEmail = val;
            return this;
        }
        public Builder mailSubject(String val){
            userEmail = val;
            return this;
        }
        public Builder mailTemplate(String val){
            userEmail = val;
            return this;
        }

        public MailParam build() {
            return new MailParam(this);
        }

    }

    public String getMessageHead() {
        return messageHead;
    }

    public void setMessageHead(String messageHead) {
        this.messageHead = messageHead;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailTemplate() {
        return mailTemplate;
    }

    public void setMailTemplate(String mailTemplate) {
        this.mailTemplate = mailTemplate;
    }

    @Override
    public String toString() {
        return "MailParam{" +
                "messageHead='" + messageHead + '\'' +
                ", systemName='" + systemName + '\'' +
                ", origin='" + origin + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", mailTemplate='" + mailTemplate + '\'' +
                '}';
    }
}
