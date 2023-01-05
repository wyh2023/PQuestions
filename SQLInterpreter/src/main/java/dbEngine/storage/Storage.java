package dbEngine.storage;

import dbEngine.document.Document;

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
}
