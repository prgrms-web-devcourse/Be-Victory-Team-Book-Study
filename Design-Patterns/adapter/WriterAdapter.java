public class WriterAdapter implements XmlWriter {
    private final LatestWriter jsonWriter;

    public WriterAdapter(LatestWriter jsonWriter) {
        this.jsonWriter = jsonWriter;
    }

    @Override
    public String write(Xml xml) {
        Json convertedJson = new Json(xml.tag, xml.value);
        return jsonWriter.write(convertedJson);
    }
}
