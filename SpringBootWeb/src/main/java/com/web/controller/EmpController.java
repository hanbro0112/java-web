package com.web.controller;

import com.web.pojo.PageBean;
import com.web.pojo.Result;
import com.web.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分頁查詢員工數據，當前頁：{}，每頁顯示條數：{}", page, pageSize);

        PageBean pageBean = empService.page(page, pageSize);
        return Result.success(pageBean);
    }
}
