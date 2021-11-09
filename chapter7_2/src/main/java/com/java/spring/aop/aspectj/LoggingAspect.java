package com.java.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.java.spring.aop..*Logic.*())")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{} :: {}", joinPoint.getClass().getName(), joinPoint.getSignature());

        var result = joinPoint.proceed();

        return result;
    }
}
