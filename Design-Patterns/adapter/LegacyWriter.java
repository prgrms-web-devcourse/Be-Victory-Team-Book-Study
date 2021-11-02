// CLIENT
public class LegacyWriter implements XmlWriter {
    @Override
    public String write(Xml xml) {
        return String.format("<%s>%s</%s>", xml.tag, xml.value, xml.tag);
    }
}
