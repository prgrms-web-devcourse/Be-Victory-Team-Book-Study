package chapter4.QnA;

import java.util.List;

public class ParallelDriver {
    public static void main(String[] args) {
        List<String> list = List.of(
                "오징어게임", "검은태양", "이터널스", "너의이름"
        );

        list.forEach(ParallelDriver::print);
        System.out.println();
        list.parallelStream().forEach(ParallelDriver::print);

    }

    private static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}
