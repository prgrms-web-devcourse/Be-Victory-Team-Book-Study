package QnA.LSP_ISP;

public class Student {

    protected String name;
    protected int age;
    protected String schoolName;
    protected boolean graduated = false;

    public Student(String name, int age, String schoolName) {
        this.name = name;
        this.age = age;
        this.schoolName = schoolName;
    }

    protected void study() {
        System.out.println("학생은 공부한다.");
    }

    void doHomework() {
        System.out.println("학생은 숙제를 한다.");
    }

    void getFeedback() {
        System.out.println("학생은 피드백을 받는다.");
    }

    protected boolean isGraduated() {
        return graduated;
    }
}
