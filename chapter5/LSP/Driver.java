package chapter5.LSP;

public class Driver {

    public static void main(String[] args) {
        sayNameAndSchool(new HighSchoolStudent("빅토리" , "서울고"));
        sayNameAndSchool(new UniversityStudent("빅토리" , "서울대"));
    }

    static void sayNameAndSchool(Student student) {
        student.goToSchool();
    }
}
