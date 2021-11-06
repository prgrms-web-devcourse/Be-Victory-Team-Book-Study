package chapter5.QnA.SRP_VS_ISP;

public class DvdPlayer {

    String movieName;
    DvdPlayer(String movieName) {
        this.movieName = movieName;
    }

    void on() {
        System.out.println("DVD 전원을 켭니다.");
    }

    void play() {
        System.out.printf("%s 영화를 봅니다.\n", this.movieName);
    }

    void off(){
        System.out.println("DVD 전원을 끕니다.");
    }
}
