package chapter6.templatecallback;

import chapter6.strategy.MyStrategy;

public class Soldier {
    void runContext(String sound) {
        System.out.println("전투 시작");
        executeWeapon(sound).runStrategy();
        System.out.println("전투 종료");
    }

    private chapter6.strategy.MyStrategy executeWeapon(String sound) {
        return new MyStrategy() {
            @Override
            public void runStrategy() {
                System.out.println(sound);
            }
        };
    }
}
