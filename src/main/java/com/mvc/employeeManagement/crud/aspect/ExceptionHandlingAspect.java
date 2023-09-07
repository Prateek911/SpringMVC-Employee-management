package com.mvc.employeeManagement.crud.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {


    @AfterThrowing(
            pointcut = "execution(* com.mvc.employeeManagement.crud.controller.*.*(..))",
            throwing = "exception"
    )
    public void handleException(JoinPoint joinPoint, Exception exception) {
        log.error("An exception occurred in method {}: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }
}
