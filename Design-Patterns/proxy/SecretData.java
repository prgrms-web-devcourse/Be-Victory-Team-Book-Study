public class SecretData implements DataRetrievable {
    @Override
    public String getData(String connection) {
        return "SENSITIVE_DATA";
    }
}
