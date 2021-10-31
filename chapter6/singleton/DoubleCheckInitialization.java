package chapter6.singleton;

public class DoubleCheckInitialization {

    private volatile static DoubleCheckInitialization instance;

    private DoubleCheckInitialization() {}

    public static DoubleCheckInitialization getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckInitialization.class) {
                if(instance == null)
                    instance = new DoubleCheckInitialization();
            }
        }
        return instance;
    }
}
