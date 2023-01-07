package dbEngine.storage;

import dbEngine.document.Document;
import ssql.info.predicate.Predicate;
import ssql.info.predicate.PredicateSet;

import java.util.List;
import java.util.stream.Stream;

public abstract class Storage {

    private final String tableName;

    protected Storage(String tableName) {
        this.tableName = tableName;
    }

    public abstract boolean insert(Document document);

    public abstract Stream<Document> selectAll();

    public String getTableName() {
        return tableName;
    }

    public abstract Stream<Document> select(PredicateSet predicates);

    public abstract Stream<Document> cut(List<String> columns, Stream<Document> res);
}
