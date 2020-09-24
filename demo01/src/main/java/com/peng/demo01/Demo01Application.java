package com.peng.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//标注这个类是一个springboot的应用
@SpringBootApplication
public class Demo01Application {

    public static void main(String[] args) {

        // springboot应用启动
        //SpringApplication类
        SpringApplication.run(Demo01Application.class, args);
    }

}
