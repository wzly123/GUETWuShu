package com.guet.wushu.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages="com.guet.wushu")
@MapperScan("com.guet.wushu.mapper")
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }

}
