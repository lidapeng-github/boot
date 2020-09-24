package com.dapeng.demo03.Controller;


import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username)  && "1234".equals(password)){
            session.setAttribute("user",username);
            return "redirect:main.html";
        }else {
            map.put("msg", "用户名或密码不正确");
            return "index";
        }
    }
}
