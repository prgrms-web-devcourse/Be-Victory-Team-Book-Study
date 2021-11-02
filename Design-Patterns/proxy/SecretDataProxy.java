import java.time.LocalDateTime;

public class SecretDataProxy implements DataRetrievable {
    private final SecretData data;

    public SecretDataProxy(SecretData data) {
        this.data = data;
    }

    @Override
    public String getData(String connection) {
        System.out.printf("Secret data accessed at %s%n", LocalDateTime.now());
        String data = this.data.getData(connection);
        System.out.printf("Secret data retrieved at %s%n", LocalDateTime.now());
        return data;
    }
}
