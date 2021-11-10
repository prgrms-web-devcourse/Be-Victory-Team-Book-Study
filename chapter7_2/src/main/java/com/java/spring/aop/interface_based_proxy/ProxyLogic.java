package com.java.spring.aop.interface_based_proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProxyLogic implements MyLogic {

    MyLogic targetLogic;

    ProxyLogic(MyLogic targetLogic) {
        this.targetLogic = targetLogic;
    }

    @Override
    public String doSomething() {
        log.info("Proxy Instance :: doSomething");
        return targetLogic.doSomething();
    }

    @Override
    public String doNothing() {
        return targetLogic.doNothing();
    }
}
