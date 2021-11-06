package chapter6.decorator;

import chapter6.proxy.ProxyService;

public class ClientWithDecorator {

    public static void main(String[] args) {
        MyService service = new DecoratorService();
        System.out.println(service.runSomething());
    }
}
