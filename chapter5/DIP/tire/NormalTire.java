package chapter5.DIP.tire;

public class NormalTire implements Tire {
    @Override
    public void roll() {
        System.out.println("보통 타이어가 굴러갑니다.");
    }
}
