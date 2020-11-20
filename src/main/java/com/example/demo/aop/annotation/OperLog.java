package com.example.demo.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)//标记该注解标记在方法上
@Retention(RetentionPolicy.RUNTIME)//运行时起作用
@Documented
public @interface OperLog {
    String operModul() default ""; // 操作模块
    String operType() default "";  // 操作类型
    String operDesc() default "";  // 操作说明
}
