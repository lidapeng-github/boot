package com.dapeng.controller;


import com.dapeng.mapper.UserMapper;
import com.dapeng.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/query")
    public List<User> queryAll(){
        List<User> users = userMapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
}
