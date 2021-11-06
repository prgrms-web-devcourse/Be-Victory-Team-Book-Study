package chapter6.factorymethod;

public class Dog extends Animal{
    @Override
    AniamlToy getToy() {
        return new DogToy();
    }
}
