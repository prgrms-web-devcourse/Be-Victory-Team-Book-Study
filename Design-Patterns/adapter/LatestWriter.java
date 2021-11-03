// SERVICE
public class LatestWriter {
    public String write(Json json) {
        return String.format("{%s:'%s'}", json.key, json.value);
    }
}
