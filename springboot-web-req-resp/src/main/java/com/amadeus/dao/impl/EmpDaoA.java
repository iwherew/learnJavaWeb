package com.amadeus.dao.impl;

import com.amadeus.dao.EmpDao;
import com.amadeus.pojo.Emp;
import com.amadeus.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component // 将当前类交给IOC容器管理，成为IOC容器中的bean - 控制反转
// 可以声明名称，要是声明就默认为类的名称，首字母小写
//@Repository("daoA")
@Repository
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        // 1.加载并解析emp.xml
        // 获取解析xml文件的路径
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        // 通过工具类将xml中的数据解析到list集合    file是xml文件路径 xml中的数据要往那个对象里去封装
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
