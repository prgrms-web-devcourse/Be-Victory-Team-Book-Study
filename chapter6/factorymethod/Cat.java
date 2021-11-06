package chapter6.factorymethod;

public class Cat extends Animal {
    @Override
    AniamlToy getToy() {
        return new CatToy();
    }
}
