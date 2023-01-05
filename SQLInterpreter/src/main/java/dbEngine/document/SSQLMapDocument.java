package dbEngine.document;

import dbEngine.document.Document;

import java.util.HashMap;
import java.util.Map;

public class SSQLMapDocument extends Document {

    private final Map<String, String> record;

    public SSQLMapDocument(String[] columns, String[] docs, int len) {
        record = new HashMap<>();
        for (int i = 0; i < len; i++) {
            record.put(columns[i], docs[i]);
        }
    }

}
