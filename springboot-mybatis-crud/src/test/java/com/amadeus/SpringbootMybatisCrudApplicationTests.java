package com.amadeus;

import com.amadeus.mapper.EmpMapper;
import com.amadeus.pojo.Emp;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    public EmpMapper empMapper;

    @Test
    public void testDelete(){
        empMapper.delete(16);
    }

    @Test
    public void testInsert() {
        // 设置要插入的员工信息
        Emp emp = new Emp();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2021, 12, 23));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("TOM1");
        emp.setName("汤姆1");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 25));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }

    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(18);
        System.out.println(emp);
    }

    @Test
    public void testList(){
//        List<Emp> empList = empMapper.list("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
        List<Emp> empList = empMapper.list(null,(short)1,null,null);
        System.out.println(empList);
    }

    @Test
    public void testUpdate2() {
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("TOM33");
        emp.setName("汤姆33");
        emp.setGender((short) 1);
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update2(emp);
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> ids = Arrays.asList(13, 14, 15);
        empMapper.deleteByIds(ids);
    }

    @Test
    public void testQueryById(){
        Emp emp = empMapper.queryById(1);
        System.out.println(emp);
    }
}
