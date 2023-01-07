package dbEngine;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class TableCatalog {

    private static TableCatalog tableCatalog;

    private final Set<String> tableNames;

    private TableCatalog() {
        this.tableNames = new HashSet<>();
    }

    public static TableCatalog getInstance() {
        if (tableCatalog == null) {
            tableCatalog = new TableCatalog();
        }
        return tableCatalog;
    }

    public boolean contains(String tableName) {
        return tableNames.contains(tableName);
    }

    public void addTable(String tableName) {
        tableNames.add(tableName);
    }

    public Stream<String> traverseTables() {
        return tableNames.stream();
    }

}
