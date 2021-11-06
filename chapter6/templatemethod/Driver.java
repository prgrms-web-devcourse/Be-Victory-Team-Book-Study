package chapter6.templatemethod;

public class Driver {

    public static void main(String[] args) {
        Animal doongdoong = new Dog();
        Animal sosa = new Cat();

        doongdoong.playWithOwner();
        System.out.println("----------");
        sosa.playWithOwner();

    }
}
