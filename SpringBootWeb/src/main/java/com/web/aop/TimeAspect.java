package com.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect // AOP類
public class TimeAspect {

    @Around("com.web.aop.MyAspect.pt()") // 切入點表達式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        log.info("{} 方法執行時間：{} 毫秒", joinPoint.getSignature(), end - begin);

        return result;
    }
}
