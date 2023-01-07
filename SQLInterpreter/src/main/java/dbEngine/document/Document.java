package dbEngine.document;

import java.util.Map;
import java.util.stream.Stream;

public abstract class Document {

    protected int len;

    public abstract Stream<Map.Entry<String, String>> retrieve();

    public abstract String getColumn(String col);

    public abstract boolean judge(String column, String content);

    public int getLen() {
        return len;
    }
}
