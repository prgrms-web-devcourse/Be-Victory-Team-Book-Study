public class Main {
    public static void main(String[] args) {
        Calculatable plus = new PlusModule();
        Calculatable minus = new MinusModule();
        Calculator calculator = new Calculator(plus);

        System.out.println(calculator.calculate(10, 5));

        calculator.setModule(minus);
        System.out.println(calculator.calculate(10, 5));
    }
}
