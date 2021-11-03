public class NameDecorator implements Printer {
    private final Printer printer;

    public NameDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String print(String name) {
        String innerResult = printer.print(name);
        return String.format("%s the Great", innerResult);
    }
}
