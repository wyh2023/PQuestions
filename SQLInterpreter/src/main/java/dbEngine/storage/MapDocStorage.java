package dbEngine.storage;

import dbEngine.document.Document;
import dbEngine.document.SSQLMapDocument;
import ssql.info.predicate.Predicate;
import ssql.info.predicate.PredicateSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapDocStorage extends Storage {

    private final List<Document> documents = new ArrayList<>();

    MapDocStorage() {
        super(null);
    }

    MapDocStorage(String tableName) {
        super(tableName);
    }

    public boolean insert(Document document) {
        return documents.add(document);
    }

    @Override
    public Stream<Document> selectAll() {
        return documents.stream();
    }

    @Override
    public Stream<Document> select(PredicateSet predicates) {
        List<Document> ret = new ArrayList<>();
        documents.stream()
                .filter(predicates::checkContain)
                .forEach(ret::add);
        return ret.stream();
    }

    // TODO: optimize this method.
    @Override
    public Stream<Document> cut(List<String> columns, Stream<Document> docs) {
        List<Document> ret = new ArrayList<>();
        String[] contents = new String[columns.size()];
        String[] cols = columns.toArray(new String[]{});
        docs.forEach(doc -> {
            int i = 0;
            for (String col : columns) {
                contents[i++] = doc.getColumn(col);
            }
            ret.add(new SSQLMapDocument(cols, contents, i));
        });
        return ret.stream();
    }
}
