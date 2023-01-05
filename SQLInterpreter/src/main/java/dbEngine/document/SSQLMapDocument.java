package dbEngine.document;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SSQLMapDocument extends Document {

    private final Map<String, String> record;

    @Override
    public Stream<Map.Entry<String, String>> retrieve() {
        return record.entrySet().stream();
    }

    public SSQLMapDocument(String[] columns, String[] docs, int len) {
        this.len = len;
        record = new HashMap<>();
        for (int i = 0; i < len; i++) {
            record.put(columns[i], docs[i]);
        }
    }

}
