package com.peng.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyContrialler {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","傻逼平你好");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(Model model){

        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update(Model model){

        return "user/update";
    }

    @RequestMapping("/tologin")
    public String tologin(Model model){

        return "login";
    }

    @RequestMapping("/login")
    public String login(String username,String password,Model model){

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","不存在");
            return "login";
        }

    }


    @RequestMapping("/Unauthorized")
    public String unauthorized( ){

        return "Unauthorized";
    }
}
