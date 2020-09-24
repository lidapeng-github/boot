package com.peng.service;

import com.peng.Mapper.UserDao;
import com.peng.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private  UserDao userDao;

    @Override
    public User queryByName(String name) {
        return userDao.queryByName(name);
    }
}
