package com.java.spring.aop.subclass_based_proxy;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SomethingMethodMatcher extends StaticMethodMatcherPointcut {

    private final String SOMETHING = "Something";
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().endsWith(SOMETHING);
    }
}
