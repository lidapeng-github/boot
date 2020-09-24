package com.peng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

@EnableAsync      //异步开启

@EnableScheduling  //定时功能注解
public class Demo10TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo10TaskApplication.class, args);
    }

}
