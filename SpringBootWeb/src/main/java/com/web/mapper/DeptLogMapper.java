package com.web.mapper;

import com.web.pojo.DeptLog;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(create_time, description) values(#{createTime}, #{description})")
    void insert(DeptLog deptLog);
}
