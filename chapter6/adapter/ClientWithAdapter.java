package chapter6.adapter;

public class ClientWithAdapter {

    public static void main(String[] args) {
        MyJDBC myOracleAdapter = new MyOracleAdapter();
        MyJDBC yourSQLAdapter = new YourSQLAdapter();

        myOracleAdapter.getConnection();
        yourSQLAdapter.getConnection();
    }
}
