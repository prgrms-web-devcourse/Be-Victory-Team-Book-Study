package chapter6.singleton;

public class EagerInitialization {

    private static EagerInitialization uniqueInstance = new EagerInitialization();

    private EagerInitialization() {}

    public static EagerInitialization getInstance() {
        return uniqueInstance;
    }
}
