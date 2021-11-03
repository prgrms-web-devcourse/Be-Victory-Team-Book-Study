package chapter5.QnA.SRP_VS_ISP;

public class Light {
    void dim(int percent) {
        System.out.printf("조도를 %d%s 낮춥니다.\n", percent, "%");
    }

    void off() {
        System.out.println("불을 끕니다");
    }
}
