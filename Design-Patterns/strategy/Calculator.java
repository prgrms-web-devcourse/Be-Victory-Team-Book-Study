public class Calculator {
    Calculatable module;

    public Calculator(Calculatable module) {
        this.module = module;
    }

    public void setModule(Calculatable module) {
        this.module = module;
    }

    public int calculate(int param1, int param2) {
        return module.calculate(param1, param2);
    }
}
