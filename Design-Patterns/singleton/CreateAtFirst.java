public class CreateAtFirst {
    private final static CreateAtFirst createAtFirst = new CreateAtFirst();

    private CreateAtFirst() {
    }

    public static CreateAtFirst getInstance() {
        return createAtFirst;
    }
}
