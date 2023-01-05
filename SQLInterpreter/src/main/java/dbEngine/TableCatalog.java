package dbEngine;


import java.util.HashSet;
import java.util.Set;

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

    public boolean isTableExist(String tableName) {
        return tableNames.contains(tableName);
    }

    public void addTable(String tableName) {
        tableNames.add(tableName);
    }

}
