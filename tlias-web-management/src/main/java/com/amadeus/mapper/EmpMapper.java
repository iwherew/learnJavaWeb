package com.amadeus.mapper;

import com.amadeus.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select count(*) from emp")
//    public Long count();

//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

//    @Select("select * from emp")
    public List<Emp> list(@Param("name") String name,@Param("gender") Short gender,@Param("begin") LocalDate begin,@Param("end") LocalDate end);

    void delete(@Param("ids") List<Integer> ids);

    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(@Param("id") Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id = #{id}")
    void deleteByDeptId(@Param("id") Integer id);
}
