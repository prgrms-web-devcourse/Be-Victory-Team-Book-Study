import java.time.LocalDateTime;

public class TimeStampDecorator implements Printer {
    private final Printer printer;

    public TimeStampDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String print(String name) {
        String innerResult = printer.print(name);
        return String.format("%s: %s", LocalDateTime.now(), innerResult);
    }
}