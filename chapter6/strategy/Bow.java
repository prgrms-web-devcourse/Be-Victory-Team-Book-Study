package chapter6.strategy;

public class Bow implements MyStrategy{

    @Override
    public void runStrategy() {
        System.out.println("활이닷!! 피융~ !슉슉");
    }
}
