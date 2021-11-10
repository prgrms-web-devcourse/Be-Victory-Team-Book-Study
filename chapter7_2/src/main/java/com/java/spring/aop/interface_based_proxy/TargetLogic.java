package com.java.spring.aop.interface_based_proxy;

public class TargetLogic implements MyLogic{
    @Override
    public String doSomething() {
        return "Do Target Logic in implemented instance";
    }

    @Override
    public String doNothing() {
        return "Do Nothing";
    }
}
