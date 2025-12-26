package com.web.service.impl;

import com.web.mapper.DeptMapper;
import com.web.mapper.EmpMapper;
import com.web.pojo.Dept;
import com.web.pojo.DeptLog;
import com.web.service.DeptService;
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
    private DeptLogServiceImpl deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);

        empMapper.deleteByDeptId(id);

        // 寫入操作日誌
        DeptLog deptLog = new DeptLog();
        deptLog.setCreateTime(LocalDateTime.now());
        deptLog.setDescription("Deleted department with ID: " + id);
        deptLogService.insert(deptLog);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }
}
