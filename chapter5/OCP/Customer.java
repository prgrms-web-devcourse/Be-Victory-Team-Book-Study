
package chapter5.OCP;
public class Customer {

    public static void main(String[] args) {
        var sellingPerson = new SellingPerson();
        var securityPerson = new SecurityPerson();
        var cleaningPerson = new CleaningPerson();
        var boss = new Boss();
        buy(sellingPerson);
        buy(securityPerson);
        buy(cleaningPerson);
        buy(boss);
    }

    static void buy(Selling sellingPerson) {
        sellingPerson.sell();
    }
}
