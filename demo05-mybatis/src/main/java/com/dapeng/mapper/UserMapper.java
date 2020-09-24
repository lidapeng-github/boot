package com.dapeng.mapper;


import com.dapeng.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User> queryAll();
}
