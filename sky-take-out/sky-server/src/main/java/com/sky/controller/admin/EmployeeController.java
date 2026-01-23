package com.sky.controller.admin;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.result.Result;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理
 */
@RestController
@RequestMapping("/admin/employee")
@Slf4j
@Api(tags = "員工相關接口")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("員工登錄，參數: {}", employeeLoginDTO);

        Employee employee = employeeService
    }
}
