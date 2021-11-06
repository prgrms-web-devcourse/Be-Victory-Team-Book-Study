package chapter5.QnA.DIP_VS_DI;

public class PizzaStore implements Store {
    private final Pizza[] pizzas;

    public PizzaStore(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public void sell(int count) {
        System.out.printf("%d 개중 %d의 피자를 팔겠습니다.", pizzas.length, count);
    }
}
