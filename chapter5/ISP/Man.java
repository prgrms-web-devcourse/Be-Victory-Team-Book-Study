package chapter5.ISP;

public class Man implements Son, BoyFriend, Staff, Soldier{
    @Override
    public void 키스하기() {
        System.out.println("여자친구와 키스하기");
    }

    @Override
    public void 기념일챙기기() {
        System.out.println("여자친구와 기념일챙기기");
    }

    @Override
    public void 사격하기() {
        System.out.println("부대에서 사격하기");
    }

    @Override
    public void 구보하기() {
        System.out.println("부대에서 구보뛰기");
    }

    @Override
    public void 효도하기() {
        System.out.println("부모님께 효도하기");
    }

    @Override
    public void 안마하기() {
        System.out.println("부모님 안마해드리기");
    }

    @Override
    public void 출근하기() {
        System.out.println("직장으로 출근하기");
    }

    @Override
    public void 아부하기() {
        System.out.println("직장상사에게 아부하기");
    }
}
