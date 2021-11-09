package com.java.spring.aop.aspectj;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {

    @Pointcut("execution(public * com.java.spring.aop..*Logic.*Something())")
    public void loggingBeforeMethod() {}
}
