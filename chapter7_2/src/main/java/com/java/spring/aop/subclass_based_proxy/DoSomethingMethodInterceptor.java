package com.java.spring.aop.subclass_based_proxy;



import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodMatcher;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class DoSomethingMethodInterceptor implements MethodInterceptor {

    private final MethodMatcher methodMacher;

    public DoSomethingMethodInterceptor(MethodMatcher methodMatchers) {
        this.methodMacher = methodMatchers;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(methodMacher.matches(method, o.getClass())) {
            log.info("CGLIB proxy :: " + method.getName());
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
