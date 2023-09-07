package com.mvc.employeeManagement.crud.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmployeeListLoggingAspect {

    @Before("execution(* com.mvc.employeeManagement.crud.controller.EmployeeController.listEmployees(..))")
    public void beforeListEmployees(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("Before retrieving the list of employees. Method parameters: {}", args);
    }

    @AfterReturning(
            pointcut = "execution(* com.mvc.employeeManagement.crud.controller.EmployeeController.listEmployees(..))",
            returning = "result"
    )
    public void afterReturningListEmployees(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        log.info("After successfully retrieving the list of employees. Method parameters: {}", args);
    }

    @AfterThrowing(
            pointcut = "execution(* com.mvc.employeeManagement.crud.controller.EmployeeController.listEmployees(..))",
            throwing = "exception"
    )
    public void afterThrowingListEmployees(JoinPoint joinPoint, Throwable exception) {
        Object[] args = joinPoint.getArgs();
        log.error("Error occurred while retrieving the list of employees. Method parameters: {}", args, exception);
    }
}
