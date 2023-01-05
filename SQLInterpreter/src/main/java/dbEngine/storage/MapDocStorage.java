package dbEngine.storage;

import dbEngine.document.Document;

import java.util.ArrayList;
import java.util.List;

public class MapDocStorage extends Storage {

    private final List<Document> documents;

    MapDocStorage(String tableName) {
        super(tableName);
        this.documents = new ArrayList<>();
    }

    public boolean insert(Document document) {
        return documents.add(document);
    }

}
