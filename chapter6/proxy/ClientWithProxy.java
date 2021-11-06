package chapter6.proxy;

public class ClientWithProxy {

    public static void main(String[] args) {
        MyService service = new ProxyService();
        System.out.println(service.runSomething());
    }
}
