package chapter5.DIP.driver;

public class BestDriver implements Driver {
    @Override
    public void drive() {
        System.out.println("베스트 드라이버가 부드럽게 운전을 합니다.");
    }
}
