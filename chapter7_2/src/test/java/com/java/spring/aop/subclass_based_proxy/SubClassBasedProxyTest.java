package com.java.spring.aop.subclass_based_proxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SubClassBasedProxyTest {

    @Test
    @DisplayName("cglib proxy 객체는 로그를 찍는다.")
    void testDynamicProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealLogic.class);
        enhancer.setCallback(new DoSomethingMethodInterceptor(new SomethingMethodMatcher()));

        RealLogic proxiedLogic = (RealLogic) enhancer.create();

        assertThat(proxiedLogic.doSomething(), is("Do Real Logic in subclass"));
        assertThat(proxiedLogic.doNothing(), is("Do Nothing"));
    }
}
