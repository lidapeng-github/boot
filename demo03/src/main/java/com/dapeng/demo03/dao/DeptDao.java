package com.dapeng.demo03.dao;


import com.dapeng.demo03.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DeptDao {

    List<Dept> queryAll();

    Dept queryById(Integer id);
}
