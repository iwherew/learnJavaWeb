package com.amadeus.service.impl;

import com.amadeus.anno.MyLog;
import com.amadeus.mapper.DeptMapper;
import com.amadeus.mapper.EmpMapper;
import com.amadeus.pojo.Dept;
import com.amadeus.pojo.DeptLog;
import com.amadeus.service.DeptLogService;
import com.amadeus.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @MyLog
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

//    @Transactional // spring事务管理（回滚运行时异常 RuntimeException）
    @Transactional(rollbackFor = Exception.class) // 出现所有的异常都回滚
    @Override
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id);
//            System.out.println(1/0);
//            if(true){
//                throw new Exception("出错了");
//            }
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }

    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @MyLog
    @Override
    public Dept queryById(Integer id) {

        return deptMapper.queryById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
