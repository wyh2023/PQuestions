package dbEngine.storage;

import dbEngine.document.Document;

public abstract class Storage {

    private final String tableName;

    protected Storage(String tableName) {
        this.tableName = tableName;
    }

    public abstract boolean insert(Document document);
}
