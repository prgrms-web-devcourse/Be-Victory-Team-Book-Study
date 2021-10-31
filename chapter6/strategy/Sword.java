package chapter6.strategy;

public class Sword implements MyStrategy{
    @Override
    public void runStrategy() {
        System.out.println("검이닷!! 체챙챙!~");
    }
}
