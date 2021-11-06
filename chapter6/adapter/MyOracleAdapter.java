package chapter6.adapter;

public class MyOracleAdapter implements MyJDBC{

    MyOracle myOracle = new MyOracle();

    @Override
    public void getConnection() {
        myOracle.getOracleConnection();
    }
}
