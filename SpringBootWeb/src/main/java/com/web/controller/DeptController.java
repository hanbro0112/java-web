package com.web.controller;

import com.web.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DeptController {

    @GetMapping("/dept")
    public Result list() {
        log.info("查詢全部部門數據");
        return Result.success();
    }
}
