package com.example.demo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OperationLog {

    private String operId;
    //操作模块
    private String operModul;
    //操作类型
    private String operType;
    //操作说明
    private String operDesc;
    //操作方法名
    private String operMethod;
    //请求参数
    private String operRequParam;
    //返回参数
    private String operRespParam;
    //操作IP
    private String operIp;
    //操作URL
    private String operUri;
    //创建时间
    private LocalDateTime operCreateTime;
}
