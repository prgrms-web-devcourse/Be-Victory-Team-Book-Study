public class LightWriter extends MailWriter {
    @Override
    public void writeReceiver(String name) {
        super.sb.append(String.format("%s the great!", name));
    }

    @Override
    public void writePs() {
        super.sb.append("Don't forget to bring my umbrella back!");
    }
}