package chapter6.templatecallback;

import chapter6.templatecallback.MyStrategy;

public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext("총초초초오오옹!!!");

        soldier.runContext("카카라칼 쉥쉥엥잉~~");

        soldier.runContext("독끼!!!도도도끼끼끼끾");
    }
}
