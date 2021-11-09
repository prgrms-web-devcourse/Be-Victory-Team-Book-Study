package com.java.spring.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class SpecialLogic {

    public String doSpecial() {
        return "Do Special Logic";
    }
}
