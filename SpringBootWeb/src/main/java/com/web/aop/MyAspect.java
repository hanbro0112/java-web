package com.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.web.service.impl.DeptServiceImpl.*(..))")
    private void pt() {};

    @Before("pt()")
    public void before() {
        log.info("前置通知");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("環繞前通知");

        Object result = joinPoint.proceed();

        log.info("環繞後通知");
        return result;
    }

    @After("pt()")
    public void after() {
        log.info("後置通知");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("返回後通知");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("異常後通知");
    }
}
