package com.dapeng.demo03.dao;


import com.dapeng.demo03.pojo.Dept;
import com.dapeng.demo03.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmpDao {

    List<Emp> getAll();

    Emp queryById(int id);

    int add(Emp emp);

    int update(Emp emp);

    int delete(Integer id);

    Boolean queryId(int id);
}
