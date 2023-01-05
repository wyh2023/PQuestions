package ssql;

import java.util.List;

public class QueryInfo {

    private final List<String> columns;

    private final String table;

    public QueryInfo(List<String> cols, String t) {
        columns = cols;
        table = t;
    }

    public List<String> getColumns() {
        return columns;
    }

    public String getTable() {
        return table;
    }
}
