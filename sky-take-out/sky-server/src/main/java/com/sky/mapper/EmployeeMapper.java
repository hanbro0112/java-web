package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
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
    @AutoFill(OperationType.INSERT)
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
    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);
}
