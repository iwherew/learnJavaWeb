package com.amadeus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data//get set 以及toString方法
@NoArgsConstructor// 无参构造
@AllArgsConstructor// 全参构造
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private short gender;
    private String image;
    private short job;
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}