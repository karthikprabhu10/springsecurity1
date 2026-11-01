package com.jsp.empmanagement.aop;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
//    @Before("execution (*  com.jsp.empmanagement.*.*.* (..))")
//    public void beforeMethodExecution(JoinPoint joinPoint){
//        log.info("From Before LoggingAspect: "+joinPoint.getSignature()+"With args: "+joinPoint.getArgs());
//    }

    @Around("execution (*  com.jsp.empmanagement.*.*.* (..))")
    public Object afterMethodExecution(ProceedingJoinPoint joinPoint){
        log.info("Before: LoggingAspect: "+joinPoint.getSignature()+"With args: "+ Arrays.toString(joinPoint.getArgs()));
    Object result;
        long beforeTime = System.currentTimeMillis();
        try {
            result =   joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long afterTime = System.currentTimeMillis();
        log.info("After: "+joinPoint.getSignature()+"time consumed: "+(afterTime-beforeTime));
     return result;
    }
}
