package chapter5.OCP;

public class Boss implements Selling{
    @Override
    public void sell() {
        System.out.println("사장님이 물건을 팝니다.");
    }
}
