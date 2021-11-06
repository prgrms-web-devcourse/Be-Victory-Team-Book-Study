package chapter6.templatemethod;

public class Dog extends Animal {

    @Override
    public void play() {
        System.out.println("멍멍!!!");
    }

    @Override
    //Hook (갈고리) 메소드 오버라이딩
    public void runSomething() {
        System.out.println("멍멍!! 꼬리 살랑살랑");
    }

}
