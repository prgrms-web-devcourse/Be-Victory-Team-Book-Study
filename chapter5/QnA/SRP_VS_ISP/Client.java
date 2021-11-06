package chapter5.QnA.SRP_VS_ISP;


public class Client {

    private static final String movieName = "신세계";

    public static void main(String[] args) {
        movieWithFacade();
        movieWithoutFacade();
    }

    private static void movieWithFacade() {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(movieName);
        homeTheater.watchMovie();

        homeTheater.endMovie();
    }

    private static void movieWithoutFacade() {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer(movieName);
        PopcornPopper popper = new PopcornPopper();
        Light light = new Light();
        Screen screen = new Screen();
        Projector projector = new Projector();

        System.out.println("==============영화를 볼겁니다.");
        popper.on();
        popper.pop();
        amp.on();
        dvd.on();
        light.dim(20);
        screen.down();
        projector.on();
        projector.setDvd();
        dvd.play();

        System.out.println("==================영화가 끝났습니다.");
        popper.off();
        dvd.off();
        projector.off();
        screen.up();
        light.off();
        amp.off();
    }
}
