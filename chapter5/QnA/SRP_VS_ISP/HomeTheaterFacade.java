package chapter5.QnA.SRP_VS_ISP;

public class HomeTheaterFacade {
    Amplifier amp;
    DvdPlayer dvd;
    PopcornPopper popper;
    Light light;
    Screen screen;
    Projector projector;

    HomeTheaterFacade(String movieName) {
        this.amp = new Amplifier();
        this.dvd = new DvdPlayer(movieName);
        this.popper = new PopcornPopper();
        this.light = new Light();
        this.screen = new Screen();
        this.projector = new Projector();
    }

    void watchMovie() {
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
    }

    void endMovie() {
        System.out.println("==================영화가 끝났습니다.");
        popper.off();
        dvd.off();
        projector.off();
        screen.up();
        light.off();
        amp.off();
    }

}
