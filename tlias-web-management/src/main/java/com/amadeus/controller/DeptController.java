package com.amadeus.controller;

import com.amadeus.pojo.Dept;
import com.amadeus.pojo.Result;
import com.amadeus.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
//    private  static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

//    @RequestMapping("/depts")
//    @GetMapping("/depts")
    @GetMapping
    public Result list(){

        log.info("查询全部部门数据");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

//    @DeleteMapping("/depts/{id}")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门:{}", id);
        deptService.delete(id);
        return Result.success();
    }

//    @PostMapping("/depts")
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id){
        Dept dept = deptService.queryById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success(dept);
    }
}
