package chapter3.QnA.LSP_ISP.concretes;

import chapter3.QnA.LSP_ISP.interfaces.Presentator;
import chapter3.QnA.LSP_ISP.interfaces.TeamLeader;

public class KdtTeamLeader extends KdtStudent implements TeamLeader, Presentator {
    public KdtTeamLeader(String name, int age, String schoolName, int stage) {
        super(name, age, schoolName, stage);
    }

    @Override
    public void lead() {
        System.out.println(super.name + " 리더는 팀을 리드합니다.");
    }

    @Override
    public void present() {
        System.out.println(super.name + " 발표자는 발표를 합니다.");
    }
}
