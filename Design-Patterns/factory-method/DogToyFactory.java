public class DogToyFactory implements ToyFactory {
    @Override
    public Toy produceToy() {
        return new DogToy();
    }
}
