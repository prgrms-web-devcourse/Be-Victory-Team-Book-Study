package chapter4.QnA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ParallelDriver {
    public static void main(String[] args) {
//        List<String> list = List.of(
//                "오징어게임", "검은태양", "이터널스", "너의이름"
//        );
//
//        list.forEach(ParallelDriver::print);
//        System.out.println();
//        list.parallelStream().forEach(ParallelDriver::print);

        var arr = new String[]{"2", "9", "10", "21", "24"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1: "+o1+" o2: "+o2);
                int k=(o2+o1).compareTo(o1+o2);  // 아스키 코드의 차이를 return 함
                System.out.println("k:"+k);
                return k; // 내림차순 정렬
            }
        });

    }

    private static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}
