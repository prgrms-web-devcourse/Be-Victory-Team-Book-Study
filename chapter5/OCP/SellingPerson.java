package chapter5.OCP;

public class SellingPerson implements Selling {
    @Override
    public void sell() {
        System.out.println("구매 담당직원이 물건을 팝니다.");
    }
}
