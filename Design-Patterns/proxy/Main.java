public class Main {
    public static void main(String[] args) {
        DataRetrievable proxiedData = new SecretDataProxy(new SecretData());
        System.out.println(proxiedData.getData("jdbc_url_here"));
        System.out.println("");

        DataRetrievable normalData = new SecretData();
        System.out.println(normalData.getData("jdbc_url_here"));
    }
}
