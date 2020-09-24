package com.dapeng.demo03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer empNo;
    private String eName;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private Double sal;
    private  Double comm;
    private Integer deptNo;
}
