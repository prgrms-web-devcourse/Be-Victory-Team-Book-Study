package chapter5.LSP;

public class HighSchoolStudent extends Student{

    HighSchoolStudent(String name, String schoolName) {
        this.name = name;
        this.schoolName = schoolName;
    }

    @Override
    void goToSchool() {
        System.out.println(this.name +" 학생은 " + this.schoolName+"으로 등교한다.");
    }
}
