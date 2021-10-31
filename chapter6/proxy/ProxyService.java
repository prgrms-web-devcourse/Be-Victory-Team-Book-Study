package chapter6.proxy;

public class ProxyService implements MyService {

    MyService service;

    @Override
    public String runSomething() {
        System.out.println("프록시로 감쌌습니다.");

        service = new RealService();
        return service.runSomething();
    }
}
