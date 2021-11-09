package com.java.spring.aop.interface_based_proxy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InterfacedBasedProxyTest {

    private final static String DO_SOMETHING="Do Target Logic in implemented instance";
    private final static String DO_NOTHING="Do Nothing";


    @Test
    @DisplayName("Proxy 객체는 로직앞에 로그를 찍는다.")
    void testProxy() {
        var proxiedLogic = new ProxyLogic(new TargetLogic());

        assertThat(proxiedLogic.doSomething(), is(DO_SOMETHING));
        assertThat(proxiedLogic.doNothing(), is(DO_NOTHING));
    }

    @Test
    @DisplayName("DynamicProxy 객체는 로직앞에 로그를 찍는다.")
    void testDynamicProxy() {
        MyLogic proxiedLogic = (MyLogic) Proxy.newProxyInstance(
                MyDynamicProxyHandler.class.getClassLoader(),
                new Class[]{MyLogic.class},
                new MyDynamicProxyHandler(new TargetLogic())
        );

        assertThat(proxiedLogic.doSomething(), is(DO_SOMETHING));
        assertThat(proxiedLogic.doNothing(), is(DO_NOTHING));
    }
}
