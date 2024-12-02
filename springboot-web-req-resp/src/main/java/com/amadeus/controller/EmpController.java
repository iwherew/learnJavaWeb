package com.amadeus.controller;

import com.amadeus.pojo.Emp;
import com.amadeus.pojo.Result;
import com.amadeus.service.EmpService;
import com.amadeus.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
    三层架构：Controller Service Dao
    @Component: 可以细分为@Controller @Service @Repository
    @RestController 包含 @Controller
    扫描范围：启动类 @SpringBootApplication 默认扫描当前包及其子包，包外需要在启动类中加 @ComponentScan({"当前包名","其他需要扫描的包名"})

    @Autowired注解，默认是按照类型进行，如果存在多个相同类型的bean
    1.@Primary : 优先使用
    2.@Autowired + @Qualifier("bean的名称") ： 指定使用，bean的名称首字母小写，按类型注入
    2.@Resource(name =  "bean的名称") ： 指定使用，bean的名称首字母小写，按名字注入

 */
@RestController
public class EmpController {

//    @Qualifier("empServiceB")
    @Autowired // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量 - 依赖注入
    private EmpService empService;

//    @Resource(name = "empServiceB")
//    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> empList = empService.listEmp();
        // 3.响应数据
        return Result.success(empList);
    }

//    @RequestMapping("/listEmp")
//    public Result list(){
//        // 1.加载并解析emp.xml
//        // 获取解析xml文件的路径
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        // 通过工具类将xml中的数据解析到list集合    file是xml文件路径 xml中的数据要往那个对象里去封装
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//
//        // 2.对数据进行转换处理
//        empList.stream().forEach(emp -> {
//            // 1:男  2：女
//            String gender = emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            }else if("2".equals(gender)){
//                emp.setGender("女");
//            }
//
//            // 1：讲师  2：班主任  3：就业指导
//            String job = emp.getJob();
//            if("1".equals(gender)){
//                emp.setJob("讲师");
//            }else if("2".equals(gender)){
//                emp.setJob("班主任");
//            }else if("3".equals(gender)){
//                emp.setJob("就业指导");
//            }
//        });
//
//        // 3.响应数据
//        return Result.success(empList);
//    }
}
