package inheritance;

public class Driver {
    public static void main(String[] args) {
        Animal anAnimal = new Animal();
        Animal aMammal = new Mammal();
        Animal anWhale = new Whale();

        anAnimal.showMe();
        aMammal.showMe();
        anWhale.showMe();
    }
}