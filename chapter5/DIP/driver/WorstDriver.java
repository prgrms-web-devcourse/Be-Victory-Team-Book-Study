package chapter5.DIP.driver;

public class WorstDriver implements Driver {

    @Override
    public void drive() {
        System.out.println("워스트 드라이버가 난폭하게 운전을 합니다.");
    }
}
