package com.amadeus.service;

import com.amadeus.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id) throws Exception;

    void add(Dept dept);

    Dept queryById(Integer id);

    void update(Dept dept);
}
