package com.web.aop;

import com.alibaba.fastjson.JSONObject;
import com.web.mapper.OperateLogMapper;
import com.web.pojo.OperateLog;
import com.web.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;;

    @Around("@annotation(com.web.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // ID
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Integer operateUser = (Integer) claims.get("id");
        // 操作時間
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作類名
        String className = joinPoint.getTarget().getClass().getName();
        // 操作方法名
        String methodName = joinPoint.getSignature().getName();
        // 方法參數
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        Long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long end = System.currentTimeMillis();

        // 返回值
        String returnValue = JSONObject.toJSONString(result);
        // 耗時 ms
        long costTime = end - begin;

        OperateLog operateLog = new OperateLog(
                null,
                operateUser,
                operateTime,
                className,
                methodName,
                methodParams,
                returnValue,
                costTime
        );
        operateLogMapper.insert(operateLog);

        log.info("AOP操作日誌：{}", operateLog);

        return result;
    }
}
