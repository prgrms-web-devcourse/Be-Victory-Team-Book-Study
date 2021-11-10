package com.java.spring.aop.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@Slf4j
class ReflectionPersonTest {

    @Test
    @DisplayName("동적으로 ReflectionPerson 인스턴스 만들기")
    void getInstanceDynamically() {
        try {
            Class<?> clazz = Class.forName("com.java.spring.aop.reflection.ReflectionPerson");
            assertThat(clazz, is(ReflectionPerson.class));

            Constructor[] cons = clazz.getDeclaredConstructors();
            log.info("constructors : {}" , Arrays.toString(cons));

            Constructor<?> con = clazz.getDeclaredConstructor();
            log.info("declaredcon : {}", con);

            Object obj = con.newInstance();
            assertThat(obj instanceof ReflectionPerson, is(true));

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("동적으로 method 실행하기")
    void invokeMethodDynamically() {
        try {
            final String address = "Songpa";

            Class<?> clazz = Class.forName("com.java.spring.aop.reflection.ReflectionPerson");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            Method[] methods = clazz.getMethods();
            Arrays.stream(methods).forEach(
                    m-> log.info("methodName : {}", m.getName())
            );

            Method setMethod = Arrays.stream(methods)
                    .filter(m-> m.getName().startsWith("set"))
                    .findAny().get();

            setMethod.invoke(obj, address);

            Method getAddressMethod = Arrays.stream(methods)
                    .filter(m->m.getName().equals("getAddress"))
                    .findAny().get();

            String invokedAddress = String.valueOf(getAddressMethod.invoke(obj));

            assertThat(invokedAddress, is(address));

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}