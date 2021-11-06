package chapter6.strategy;

public class Gun implements MyStrategy {
    @Override
    public void runStrategy() {
        System.out.println("총이닷 탕탕탕!!");
    }
}
