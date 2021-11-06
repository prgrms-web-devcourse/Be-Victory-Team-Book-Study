package chapter6.factorymethod;

public class Driver {
    public static void main(String[] args) {
        Animal doong = new Dog();
        Animal sosa = new Cat();

        //팩토리 메소드 사용
        AniamlToy tennisball = doong.getToy();
        AniamlToy catTower = sosa.getToy();

        tennisball.identity();
        catTower.identity();
    }
}
