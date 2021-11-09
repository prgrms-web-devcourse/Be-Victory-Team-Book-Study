package com.java.spring.aop.aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.java.spring.aop..*Logic.*Something())")
    public void logBefore(JoinPoint joinPoint) {
        log.info("before {} :: {}", joinPoint.getTarget().getClass().getCanonicalName(), joinPoint.getSignature().getName());
    }

//    @After("execution(public * com.java.spring.aop..*Logic.do*())")
    public void logAfter(JoinPoint joinPoint) {
        log.info("after {} :: {}", joinPoint.getTarget().getClass().getCanonicalName(), joinPoint.getSignature().getName());
    }

    @Around("execution(public * com.java.spring.aop..*.*())")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around Before {} :: {}", joinPoint.getTarget().getClass().getCanonicalName(), joinPoint.getSignature().getName());
        var result = joinPoint.proceed();
        log.info("around After result =>  {} ", result);
        return result;
    }
}
