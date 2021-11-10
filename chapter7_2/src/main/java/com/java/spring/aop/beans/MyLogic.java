package com.java.spring.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class MyLogic implements SpecialLogic{
    @Override
    public String doSpecial() {
        return "Do Special Logic";
    }
}
