package ssql;

import dbEngine.ColumnCatalog;
import dbEngine.TableCatalog;
import ssql.info.QueryInfo;
import ssql.info.predicate.Predicate;

import java.util.List;

public class QueryChecker {

    ColumnCatalog columnCatalog = ColumnCatalog.getInstance();

    TableCatalog tableCatalog = TableCatalog.getInstance();

    public boolean check(QueryInfo queryInfo) {
        String table = queryInfo.getTable();
        boolean runnable = checkTable(table);
        List<String> columns = queryInfo.getColumns();
        for (String col : columns) {
            runnable &= checkColumn(table, col);
        }
        for (Predicate predicate : queryInfo.getAllPredicates()) {
            runnable &= checkPredicate(predicate, table);
        }
        return runnable;
    }

    private boolean checkColumn(String table, String column) {
        if (!columnCatalog.contains(table, column)) {
            System.err.println("Column: " + column + " is undefined in " + table + "!");
            return false;
        }
        return true;
    }

    private boolean checkTable(String table) {
        if (!tableCatalog.contains(table)) {
            System.err.println("Table: " + table + " not found!");
            return false;
        }
        return true;
    }

    private boolean checkPredicate(Predicate predicate, String table) {
        return checkColumn(table, predicate.getLVal());
    }

}
