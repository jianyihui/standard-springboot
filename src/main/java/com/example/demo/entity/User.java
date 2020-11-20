package com.example.demo.entity;

import javafx.util.Builder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class User {

    private String id;
    private String userName;
    private String password;
    private Date createDate;

    private User(){

    }

    public static User newInstance() {
        return new User();
    }


    private User(Builder builder){
        id = builder.id;
        userName = builder.userName;
        password = builder.password;
        createDate = builder.createDate;
    }

    public static class Builder{
        private String id;
        private String userName;
        private String password;
        private Date createDate;


        public Builder id(String val){
            id = val;
            return this;
        }
        public Builder userName(String val){
            userName = val;
            return this;
        }
        public Builder password(String val){
            password = val;
            return this;
        }
        public Builder createDate(Date val){
            createDate = val;
            return this;
        }
        public User build() {
            return new User(this);
        }

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
