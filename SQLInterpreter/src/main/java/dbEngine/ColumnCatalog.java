package dbEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ColumnCatalog {

    private static ColumnCatalog columns;

    private final Map<String, Set<String>> table2col;

    private final Map<String, List<String>> table2colNames;

    private ColumnCatalog() {
        table2col = new HashMap<>();
        table2colNames = new HashMap<>();
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
            table2colNames.put(tableName, new ArrayList<>(Arrays.asList(columns)));
        }
    }

    public Stream<String> getColNames(String tableName) {
        return table2colNames.get(tableName).stream();
    }

}
