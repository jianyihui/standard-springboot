package com.example.demo.controller;


import com.example.demo.aop.annotation.OperLog;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;



    @ApiOperation(value = "插入用户信息", notes = "插入用户信息")
    @PostMapping(value = "springBootTest/insertUser")
    @Transactional
    @OperLog(operType = "POST",operDesc = "测试",operModul = "111111")
    public ResponseEntity insertUser(@RequestBody User user){
        log.info("插入用户信息");
        AtomicInteger flag = new AtomicInteger();
        List<User> userList = new ArrayList<>();
        userList = userService.getUserList(user);
        if(userList.isEmpty()){
            flag.set(userService.insertUser(user));

            redisTemplate.opsForValue().set("user"+user.getUserName(),user);
        }
        if(flag.get()>0){
            return ResponseEntity.ok();
        }
        return ResponseEntity.error();
    }


    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @PostMapping(value = "springBootTest/getUserInfo")
    public ResponseEntity getUserInfo(@RequestBody User user, HttpServletRequest request){
        log.info("获取用户信息");
        User o = (User)redisTemplate.opsForValue().get("user"+user.getUserName());
        if(o!=null){
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("userInfo",o);
            return ResponseEntity.ok().data(resultMap);
        }
        return ResponseEntity.error();
    }

}
