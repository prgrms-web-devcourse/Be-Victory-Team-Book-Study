package chapter3.QnA.LSP_ISP;

import chapter3.QnA.LSP_ISP.concretes.KdtTeamLeader;
import chapter3.QnA.LSP_ISP.concretes.UniversityStudent;
import chapter3.QnA.LSP_ISP.interfaces.JobGettable;
import chapter3.QnA.LSP_ISP.interfaces.Presentator;
import chapter3.QnA.LSP_ISP.interfaces.TeamLeader;

public class Driver {

    public static void main(String[] args) {
        var kdtLeader = new KdtTeamLeader("이하정", 26, "프로그래머스", 1);
        var univStudent = new UniversityStudent("박수빈", 25, "대학교", 1, Grade.SENIOR);
        testStudentByLSP(kdtLeader, univStudent);
        System.out.println("==============================");
        testStudentToGetJob(kdtLeader);
        testStudentToLeadTeam(kdtLeader);
        testStudentToPresent(kdtLeader);

    }


    private static void testStudentByLSP(Student kdtLeader, Student univStudent) {
        kdtLeader.study();          // 이하정 kdt 수강생은 북 스터디를 한다.
        univStudent.study();        // 박수빈 대학생은 전공을 공부한다.
        kdtLeader.doHomework();     // 학생은 숙제를 한다.
        univStudent.doHomework();   // 학생은 숙제를 한다.
        kdtLeader.getFeedback();    // 학생은 피드백을 받는다.
        univStudent.getFeedback();  // 학생은 피드백을 받는다.

        System.out.println("--------------------------");
        System.out.println("수강생.isGraduated() : " + kdtLeader.isGraduated());
        // 이하정 kdt 수강생은 1기 이다.
        // 수강생.isGraduated() : true
        System.out.println("--------------------------");
        System.out.println("대학생.isGraduated() : " + univStudent.isGraduated());
        // 박수빈 대학생은 4 학년이다
        // 박수빈 kdt 수강생은 1기 이다.
        // 대학생.isGraduated() : false
    }

    private static void testStudentToGetJob(JobGettable student) {
        student.preparePortfolio();     // 이하정 수강생은 취업을 위해 포트폴리오를 준비한다.
        student.doMyBest();             // 취준생은 항상 최선을 다한다.
    }

    private static void testStudentToLeadTeam(TeamLeader leader) {
        leader.lead();               // 이하정 리더는 팀을 리드합니다.
    }

    private static void testStudentToPresent(Presentator presentator) {
        presentator.present();      // 이하정 발표자는 발표를 합니다.
    }
}
