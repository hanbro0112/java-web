package com.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect {

    // @Pointcut("execution(* com.web.service.impl.DeptServiceImpl.*(..))")
    // @Pointcut("execution(public void com.web.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    @Pointcut("@annotation(com.web.aop.MyLog)")
    public void pt() {};

    @Before("pt()")
    public void before() {
        log.info("前置通知");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("環繞前通知");

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("類名：{}, 方法名：{}, 參數：{}", className, methodName, args);

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
