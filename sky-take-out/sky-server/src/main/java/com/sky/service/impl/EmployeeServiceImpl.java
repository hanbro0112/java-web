package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.constant.PasswordConstant;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.exception.AccountLockException;
import com.sky.exception.AccountNotFoundException;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.result.PageResult;
import com.sky.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 員工登錄
     * @param employeeLoginDTO
     * @return
     */
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
       String username = employeeLoginDTO.getUsername();
       String password = employeeLoginDTO.getPassword();

       Employee employee = employeeMapper.getByUsername(username);

       if (employee == null) {
           // 帳號不存在
           throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
       }

       password = DigestUtils.md5DigestAsHex(password.getBytes());
       if (!password.equals(employee.getPassword())) {
           // 密碼錯誤
           throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
       }

       if (employee.getStatus() == StatusConstant.DISABLE) {
           // 帳號已鎖定
           throw new AccountLockException(MessageConstant.ACCOUNT_NOT_FOUND);
       }

       return employee;
    }

    /**
     * 新增員工
     * @param employeeDTO
     */
    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        // 對象屬性拷貝
        BeanUtils.copyProperties(employeeDTO, employee);

        // 設置帳號狀態
        employee.setStatus(StatusConstant.ENABLE);

        // 設置默認密碼
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        // 通過 ThreadLocal 獲取當前登入用戶 ID
        Long currentId = BaseContext.getCurrentId();

        employee.setCreateUser(currentId);
        employee.setUpdateUser(currentId);

        employeeMapper.insert(employee);
    }

    /**
     * 員工分頁查詢
     * @param employeePageQueryDTO
     * @return
     */
    public PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO) {
        PageHelper.startPage(employeePageQueryDTO.getPage(), employeePageQueryDTO.getPageSize());

        Page<Employee> page = employeeMapper.pageQuery(employeePageQueryDTO);

        Long total = page.getTotal();
        List<Employee> records = page.getResult();
        return new PageResult(total, records);
    }
}
