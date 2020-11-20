/*
package com.example.demo.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(){

        String context = "hello"+ new Date();
        rabbitTemplate.convertAndSend("hello",context);
    }

}
*/
