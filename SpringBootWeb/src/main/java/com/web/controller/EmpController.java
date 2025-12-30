package com.web.controller;

import com.web.anno.Log;
import com.web.pojo.Emp;
import com.web.pojo.PageBean;
import com.web.pojo.Result;
import com.web.service.EmpService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分頁查詢員工數據 參數: {}, {}, {}, {} ", page, pageSize, begin, end);


        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("刪除員工 參數: {} ", ids);
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("添加員工 參數: {} ", emp);
        empService.save(emp);
        return Result.success();
    }

    @Log
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根據ID查詢員工 參數: {} ", id);
        Emp emp = empService.getById(id);

        return Result.success(emp);
    }

    /**
     * 修改員工
     * @param emp
     * @return
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改員工 參數: {} ", emp);
        empService.update(emp);
        return Result.success();
    }
}
