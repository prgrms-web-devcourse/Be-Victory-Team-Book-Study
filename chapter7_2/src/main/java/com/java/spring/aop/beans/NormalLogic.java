package com.java.spring.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class NormalLogic {

    public String doSomething() {
        return "Do Normal Logic";
    }

    public String doNothing() {
        return "Do Nothing";
    }
}
