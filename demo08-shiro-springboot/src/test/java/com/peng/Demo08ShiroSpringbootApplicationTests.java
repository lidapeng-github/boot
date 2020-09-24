package com.peng;

import com.peng.Mapper.UserDao;
import com.peng.pojo.User;
import com.peng.service.UserService;
import com.peng.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo08ShiroSpringbootApplicationTests {

    @Autowired
    UserServiceImpl us;

    @Test
    void contextLoads() {
        System.out.println(us.queryByName("aaaa"));

    }

}
