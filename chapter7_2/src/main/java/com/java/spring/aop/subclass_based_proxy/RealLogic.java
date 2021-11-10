package com.java.spring.aop.subclass_based_proxy;

public class RealLogic {
    public String doSomething() {
        return "Do Real Logic in subclass";
    }

    public String doNothing() {
        return "Do Nothing";
    }
}
