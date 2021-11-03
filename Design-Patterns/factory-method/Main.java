public class Main {
    public static void main(String[] args) {
        ToyFactory factory = new CatToyFactory();

        // play with cat first.
        factory.produceToy().play();

        // play with dog last.
        factory = new DogToyFactory();
        factory.produceToy().play();
    }
}
