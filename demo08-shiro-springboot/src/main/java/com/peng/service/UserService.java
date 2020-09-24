package com.peng.service;

import com.peng.pojo.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {


    User queryByName(String name);
}
