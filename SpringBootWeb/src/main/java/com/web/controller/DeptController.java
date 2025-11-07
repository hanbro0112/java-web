package com.web.controller;

import com.web.pojo.Dept;
import com.web.pojo.Result;
import com.web.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController()
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping()
    public Result list() {
        log.info("查詢全部部門數據");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("刪除部門數據，部門ID：{}", id);

        deptService.delete(id);
        return Result.success();
    }

    @PostMapping()
    public Result add(@RequestBody  Dept dept) {
        log.info("添加部門數據，部門名稱：{}", dept);

        deptService.add(dept);
        return Result.success();
    }

    @PutMapping()
    public Result update(@RequestBody Dept dept) {
        log.info("更新部門數據，部門信息：{}", dept);

        deptService.update(dept);
        return Result.success();
    }
}
