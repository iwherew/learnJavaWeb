package com.amadeus.mapper;

import com.amadeus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 在运行时，会自动生成该接口的实现类对象(代理对象)，并且将该对象交给TOC容器管型
public interface UserMapper {
    // 查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
