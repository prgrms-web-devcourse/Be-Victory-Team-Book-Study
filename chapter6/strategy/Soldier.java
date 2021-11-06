package chapter6.strategy;

public class Soldier {

    void runContext(MyStrategy strategy) {
        System.out.println("전투 시작");
        strategy.runStrategy();
        System.out.println("전투 종료");
    }
}
