public class Main {
    public static void main(String[] args) {
        MailWriter mw = new LightWriter();
        System.out.println(mw.writeMail("Jason", "Phillip", "Tomorrow will be another day."));
    }
}
