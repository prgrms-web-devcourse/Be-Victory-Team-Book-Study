public class CatToyFactory implements ToyFactory {
    @Override
    public Toy produceToy() {
        return new CatToy();
    }
}
