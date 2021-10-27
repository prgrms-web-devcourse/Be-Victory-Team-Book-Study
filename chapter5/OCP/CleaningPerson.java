package chapter5.OCP;

public class CleaningPerson implements Selling{

    @Override
    public void sell() {
        System.out.println("청소 담당 직원이 물건을 팝니다.");
    }
}
