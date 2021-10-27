package chapter5.ISP;

public class Driver {

    public static void main(String[] args) {
        var man = new Man();
        behaveLikeBoyFriend(man);
        behaveLikeSoldier(man);
        behaveLikeSon(man);
        behaveLikeStaff(man);
    }

    static void behaveLikeSon(Son son) {
        son.안마하기();
        son.효도하기();
    }

    static void behaveLikeBoyFriend(BoyFriend boyFriend) {
        boyFriend.기념일챙기기();
        boyFriend.키스하기();
    }

    static void behaveLikeStaff(Staff staff) {
        staff.아부하기();
        staff.출근하기();
    }

    static void behaveLikeSoldier(Soldier soldier) {
        soldier.구보하기();
        soldier.사격하기();
    }

}
