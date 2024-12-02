package com.amadeus.service.impl;

import com.amadeus.dao.EmpDao;
import com.amadeus.pojo.Emp;
import com.amadeus.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
//@Component // 将当前类交给IOC容器管理，成为IOC容器中的bean - 控制反转; 不需要时只需要注释@Component就行了
@Service
public class EmpServiceA implements EmpService {

    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量 - 依赖注入
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        // 1.调用dao，获取数据
        List<Emp> empList = empDao.listEmp();

        // 2.对数据进行转换处理
        empList.stream().forEach(emp -> {
            // 1:男  2：女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            // 1：讲师  2：班主任  3：就业指导
            String job = emp.getJob();
            if("1".equals(gender)){
                emp.setJob("讲师");
            }else if("2".equals(gender)){
                emp.setJob("班主任");
            }else if("3".equals(gender)){
                emp.setJob("就业指导");
            }
        });

        return empList;
    }
}
