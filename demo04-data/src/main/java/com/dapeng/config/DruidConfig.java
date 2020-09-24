package com.dapeng.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;
import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //后台监控
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //后台需要登录，设置账号密码
        Map<String,String> initParameters = new HashMap<>();
        //设置账号密码    key是固定格式
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //设置谁可以访问
        initParameters.put("allow","");
        //禁止访问
       // initParmeters.put("")
        bean.setInitParameters(initParameters);

        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean<>();

        Map<String,String> initParameters = new HashMap<>();

        bean.setFilter(new WebStatFilter());

        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);


        return bean;

    }
}
