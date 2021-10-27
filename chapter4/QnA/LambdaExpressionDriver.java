package chapter4.QnA;

import java.util.Iterator;
import java.util.List;

public class LambdaExpressionDriver {

    public static void main(String[] args) {
        List<Student> list = List.of(new Student("오징어", 90), new Student("오달수", 96));

        list.forEach(
                // 요소 처리 코드 - 람다
                student -> {
                    System.out.println(student.getName() + " score : " + student.getScore());
                }
        );
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getName() + " score : " + student.getScore());
        }
    }
}
