package com.web.service.impl;

import com.web.mapper.DeptLogMapper;
import com.web.pojo.DeptLog;
import com.web.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;
    
    @Override
    public void insert(DeptLog deptLog) {

    }
}
