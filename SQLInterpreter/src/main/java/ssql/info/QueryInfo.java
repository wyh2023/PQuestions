package ssql.info;

import ssql.info.predicate.Predicate;

import java.util.List;

public class QueryInfo {

    private final List<String> columns;

    private final String table;

    private final List<Predicate> predicates;

    public QueryInfo(List<String> cols, String t, List<Predicate> pres) {
        columns = cols;
        table = t;
        predicates = pres;
    }

    public List<String> getColumns() {
        return columns;
    }

    public String getTable() {
        return table;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }


}
