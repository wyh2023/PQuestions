package dbEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColumnCatalog {

    private static ColumnCatalog columns;

    private final Map<String, Set<String>> table2col;

    private ColumnCatalog() {
        table2col = new HashMap<>();
    }

    public static ColumnCatalog getInstance() {
        if (columns == null) {
            columns = new ColumnCatalog();
        }
        return columns;
    }

    public void putColumn(String tableName, String[] columns) {
        if (!table2col.containsKey(tableName)) {
            Set<String> cols = new HashSet<>(Arrays.asList(columns));
            table2col.put(tableName, cols);
        }
    }

}
