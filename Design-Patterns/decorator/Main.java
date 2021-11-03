public class Main {
    public static void main(String[] args) {
        String name = "Kwonkyu";
        Printer simplePrinter = new SimplePrinter();
        Printer nameDecorator = new NameDecorator(simplePrinter);
        Printer greetDecorator = new GreetingDecorator(nameDecorator);
        Printer timestampDecorator = new TimeStampDecorator(greetDecorator);

        System.out.println(timestampDecorator.print(name));
        System.out.println(greetDecorator.print(name));
        System.out.println(nameDecorator.print(name));
        System.out.println(simplePrinter.print(name));
    }
}