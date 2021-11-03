public class Main {
    public static void main(String[] args) {
        // DatabaseAccess access = new DatabaseAccess(); <== undefined
        // DatabaseAccess access = new DatabaseAccess("JDBC_URL_HERE"); <== not visible
        DatabaseAccess access1 = DatabaseAccess.getInstance("JDBC_URL_HERE");
        DatabaseAccess access2 = DatabaseAccess.getInstance("JDBC_URL_HERE");

        System.out.printf("Access1: %s / %s%n", access1.getJdbcUrl(), access1.getCreatedAt());
        System.out.printf("Access2: %s / %s%n", access2.getJdbcUrl(), access2.getCreatedAt());

        System.out.printf("Access1 == Access2: %s%n", access1 == access2);
        System.out.printf("Not_Singleton1 == Not_Singleton2: %s%n", (new Object()) == (new Object()));
    }
}
