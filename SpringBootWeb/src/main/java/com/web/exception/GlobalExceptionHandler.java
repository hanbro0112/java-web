package com.web.exception;

import com.web.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("操作失敗");
    }
}
