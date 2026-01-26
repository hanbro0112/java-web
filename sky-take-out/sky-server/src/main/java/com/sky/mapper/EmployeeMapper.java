package com.sky.mapper;

import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeMapper {

    /**
     * 根據用戶名查詢員工信息
     * @param username
     * @return
     */
    Employee getByUsername(@Param("username") String username);
}
