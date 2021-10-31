package chapter6.singleton;

public class LazyHolderInitialization {
    private LazyHolderInitialization() {};

    private static class LazyHolder {
        private static final LazyHolderInitialization instance = new LazyHolderInitialization();
    }

    public static LazyHolderInitialization getInstance() {
        return LazyHolder.instance;
    }
}
