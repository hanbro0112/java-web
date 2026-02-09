package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 自定義切面，公共字段自動填充
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 定義切入點，com.sky.mapper 底下的所有類和方法
     * 標註了@AutoFill註解的方法進行切面處理
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..) && @annotation(com.sky.annotation.AutoFill))")
    public void autoFillPointCut() {}

    /**
     * 在切入點方法執行之前執行，實現公共字段的自動填充
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        log.info("執行公共字段自動填充...");

        // 獲取方法簽名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 獲取方法上的@AutoFill註解
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        // 獲取註解中的數據庫操作類型
        OperationType operationType = autoFill.value();

        // 獲取當前被攔截方法的參數
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }

        // 約定方法第一位置為實體對象
        Object entity = args[0];
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();

        if (operationType == OperationType.INSERT) {
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                // 通過反射為對象賦值
                setCreateTime.invoke(entity, now);
                setCreateUser.invoke(entity, currentId);
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (operationType == OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                // 通過反射為對象賦值
                setUpdateTime.invoke(entity, now);
                setUpdateUser.invoke(entity, currentId);
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
