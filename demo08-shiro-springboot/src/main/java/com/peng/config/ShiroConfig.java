package com.peng.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    //shiroFilerFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
        * anon：无需认证
        * authc：必需认证
        * user：必需拥有  记住我  才能用
        *perms:拥有某个资源的权限才能访问
        * roles：拥有某个角色权限才能访问
        * */
        Map<String,String> map = new LinkedHashMap<>();

        map.put("/user/add","perms[user:add]");
        map.put("/user/update","perms[user:update]");

        map.put("/user/*","authc");



        bean.setFilterChainDefinitionMap(map);


        bean.setLoginUrl("/tologin");
        return bean;
    }


    //DafaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        defaultWebSecurityManager.setRealm(userRealm);

        return defaultWebSecurityManager;

    }


    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
