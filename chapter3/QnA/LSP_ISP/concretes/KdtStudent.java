package chapter3.QnA.LSP_ISP.concretes;

import chapter3.QnA.LSP_ISP.Student;
import chapter3.QnA.LSP_ISP.interfaces.JobGettable;

public class KdtStudent extends Student implements JobGettable {

    private int stage;

    public KdtStudent(String name, int age, String schoolName, int stage) {
        super(name, age, schoolName);
        this.stage = stage;
        this.graduated = !schoolName.contains("대학");;
    }

    private void sayStage() {
        System.out.println(super.name + " kdt 수강생은 " + stage + "기 이다.");
    }

    @Override
    protected void study() {
        System.out.println(super.name + " kdt 수강생은 북 스터디를 한다.");
    }

    @Override
    protected boolean isGraduated() {
        sayStage();
        return this.graduated;
    }

    @Override
    public void preparePortfolio() {
        System.out.println(super.name + " 취준생은 취업을 위해 포트폴리오를 준비한다. ");
    }
}
