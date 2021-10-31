package chapter6.adapter;

public class YourSQLAdapter implements MyJDBC {

    YourSQL yourSQL = new YourSQL();

    @Override
    public void getConnection() {
        yourSQL.getYourSQLConnection();
    }
}
