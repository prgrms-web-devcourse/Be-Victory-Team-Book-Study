package com.java.spring.aop.interface_based_proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class MyDynamicProxyHandler implements InvocationHandler {

    MyLogic targetLogic;

    MyDynamicProxyHandler(MyLogic targetLogic) {
        this.targetLogic = targetLogic;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if(method.getName().endsWith("Something")) {
            log.info("Dynamic Proxy :: " + method.getName());
            return targetLogic.doSomething();
        }
        return targetLogic.doNothing();
    }
}
