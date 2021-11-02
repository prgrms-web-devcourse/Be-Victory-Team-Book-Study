public abstract class MailWriter {
    StringBuilder sb = new StringBuilder();

    public void writeGreeting() {
        sb.append("Hello! ");
    }

    public abstract void writeReceiver(String name);

    public void writeText(String text) {
        sb.append(System.lineSeparator());
        sb.append(text);
        sb.append(System.lineSeparator());
    }

    public void writeEnding(String sender) {
        sb.append(System.lineSeparator());
        sb.append("Sincerely, " + sender);
        sb.append(System.lineSeparator());
    }

    public void writePs() {
    }

    public String writeMail(String name, String sender, String text) {
        writeGreeting();
        writeReceiver(name);
        writeText(text);
        writeEnding(sender);
        writePs();
        return sb.toString();
    }
}
