package chapter6.singleton;

public class SynchronizedInitialization {
    private static SynchronizedInitialization instance;

    private SynchronizedInitialization() {};

    public synchronized static SynchronizedInitialization getInstance() {
        if(instance == null) {
            instance = new SynchronizedInitialization();
        }
        return instance;
    }
}
