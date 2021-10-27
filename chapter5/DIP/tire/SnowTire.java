package chapter5.DIP.tire;

public class SnowTire implements Tire {
    @Override
    public void roll() {
        System.out.println("스노우 타이어가 굴러갑니다.");
    }
}
