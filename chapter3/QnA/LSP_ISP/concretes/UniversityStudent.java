package chapter3.QnA.LSP_ISP.concretes;

import chapter3.QnA.LSP_ISP.Grade;

public class UniversityStudent extends KdtStudent {

    private Grade grade;

    public UniversityStudent(String name, int age, String schoolName, int stage, Grade grade) {
        super(name, age, schoolName, stage);
        this.grade = grade;
        this.graduated = false;
    }

    @Override
    protected void study() {
        System.out.println(super.name + " 대학생은 전공을 공부한다.");
    }

    private void sayGrade() {
        System.out.println(super.name + " 대학생은 " + grade.getGrade() + " 학년이다");
    }

    @Override
    protected boolean isGraduated() {
        sayGrade();
        super.isGraduated();
        return this.graduated;
    }
}
