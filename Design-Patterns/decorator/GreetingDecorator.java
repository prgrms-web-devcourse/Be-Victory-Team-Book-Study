public class GreetingDecorator implements Printer {
    private final Printer printer;

    public GreetingDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String print(String name) {
        String innerResult = printer.print(name);
        return String.format("Hello, %s!", innerResult);
    }
}