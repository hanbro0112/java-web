package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
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

    /**
     * 新增員工
     * @param employee
     */
    void insert(Employee employee);

    /**
     * 員工分頁查詢
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根據 ID 查詢員工信息
     * @param id
     * @return
     */
    Employee getById(@Param("id") Long id);

    /**
     * 更新員工信息
     * @param employee
     */
    void update(Employee employee);
}
