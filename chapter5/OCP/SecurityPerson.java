package chapter5.OCP;

public class SecurityPerson implements Selling{

    @Override
    public void sell() {
        System.out.println("보안 담당 직원이 물건을 팝니다.");
    }
}
