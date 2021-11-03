public class Main {
    public static void main(String[] args) {
        LegacyWriter client = new LegacyWriter();
        Xml xml = new Xml("parameter", "username");
        System.out.println(client.write(xml));
        // service.write(xml); <-- incompatible.

        LatestWriter service = new LatestWriter();
        WriterAdapter adapter = new WriterAdapter(service);
        System.out.println(adapter.write(xml)); // <-- compatible by adapter.
    }
}