package QnA.LSP_ISP;

public enum Grade {
    FRESHMEN(1),
    SOPHOMORE(2),
    JUNIOR(3),
    SENIOR(4);

    private final int grade;

    Grade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

}
