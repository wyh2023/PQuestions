package ssql.info;

import ssql.info.predicate.Predicate;
import ssql.info.predicate.PredicateSet;

import java.util.List;

public class QueryInfo {

    private final List<String> columns;

    private final String table;

    private final PredicateSet predicates;

    public QueryInfo(List<String> cols, String t, PredicateSet predicateSet) {
        columns = cols;
        table = t;
        predicates = predicateSet;
    }

    public List<String> getColumns() {
        return columns;
    }

    public String getTable() {
        return table;
    }

    public List<Predicate> getAllPredicates() {
        return predicates.getAllPredicate();
    }

    public PredicateSet getPredicateSet() {
        return predicates;
    }
}
