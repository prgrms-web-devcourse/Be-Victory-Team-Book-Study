package chapter6.decorator;

public class DecoratorService implements MyService {

    MyService service;
    @Override
    public String runSomething() {
        System.out.println("호출에 대한 장식이 주목적, 클라이언트 반환 결과에 장식을 더하여 전달");

        service = new RealService();
        return "가미된 " + service.runSomething();
    }
}
