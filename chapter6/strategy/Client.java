package chapter6.strategy;

public class Client {
    public static void main(String[] args) {
        MyStrategy strategy = null;
        Soldier soldier = new Soldier();

        strategy = new Gun();
        soldier.runContext(strategy);

        strategy = new Sword();
        soldier.runContext(strategy);

        strategy = new Bow();
        soldier.runContext(strategy);
    }
}
