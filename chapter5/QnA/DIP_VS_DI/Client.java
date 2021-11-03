package chapter5.QnA.DIP_VS_DI;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        Store pizzaStore = new PizzaStore(
               List.of(new CheesePizza(), new CheesePizza()).toArray(Pizza[]::new)
        );
        pizzaStore.sell(1);
    }
}
