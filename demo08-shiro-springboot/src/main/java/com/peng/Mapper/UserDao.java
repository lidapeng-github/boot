package com.peng.Mapper;


import com.peng.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {


    User queryByName(String name);
}
