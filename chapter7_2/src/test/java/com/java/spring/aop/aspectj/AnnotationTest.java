package com.java.spring.aop.aspectj;

import com.java.spring.aop.beans.NormalLogic;
import com.java.spring.aop.beans.SpecialLogic;
import com.java.spring.aop.subclass_based_proxy.RealLogic;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringJUnitConfig
@Slf4j
public class AnnotationTest {

    @Configuration
    @ComponentScan(basePackages = {"com.java.spring.aop.aspectj",
                                    "com.java.spring.aop.beans"})
    @EnableAspectJAutoProxy
    static class Config {}


    @Autowired
    NormalLogic normalLogic;

    @Autowired
    SpecialLogic specialLogic;


    @Test
    @DisplayName("Dynamic 프록시와 CGLib 프록시를 구분한다.")
    void testProxyInstance() {
        log.info("JDK Proxy : {}", specialLogic.getClass().getName());
        log.info("CGLib Proxy : {}", normalLogic.getClass().getName());
    }


    @Test
    @DisplayName("Bean 으로 등록된 객체에만 Spring AOP가 적용된다.")
    void testAOPWithBean() {
        final String normalLogicMessage = "Do Normal Logic";
        final String nothingMessage = "Do Nothing";
        final String specialMessage = "Do Special Logic";

        assertThat(normalLogic.doSomething(), is(normalLogicMessage));
        assertThat(normalLogic.doNothing(), is(nothingMessage));
        assertThat(specialLogic.doSpecial(), is(specialMessage));

        var realLogic = new RealLogic();

        assertThat(realLogic.doSomething(), is("Do Real Logic in subclass"));
    }

}
