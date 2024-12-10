package com.amadeus.service.impl;

import com.amadeus.mapper.DeptLogMapper;
import com.amadeus.pojo.DeptLog;
import com.amadeus.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    // REQUIRED（默认值）: 加入已有的事务，受上级事务影响
    // REQUIRES_NEW ：创建新事务，不受上级事务影响
//    @Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
