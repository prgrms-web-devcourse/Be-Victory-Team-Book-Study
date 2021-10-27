
package chapter5.SRP;
public class Dog {

    final static boolean MALE = true;
    final static boolean FEMALE = false;

    boolean sex;

    void 소변보다() {
        if(sex == MALE) {
            System.out.println("다리를 들고 소변본다.");
        } else {
            System.out.println("앉아서 소변본다.");
        }
    }
}
