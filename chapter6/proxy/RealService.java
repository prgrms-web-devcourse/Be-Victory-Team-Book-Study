package chapter6.proxy;

public class RealService implements MyService {
    @Override
    public String runSomething() {
        return "서비스입니다.";
    }
}
