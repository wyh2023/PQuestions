package dbEngine.storage;

import java.awt.Stroke;
import java.util.HashMap;
import java.util.Map;

public class StorageManager {

    private final Map<String, Storage> tables;

    private static StorageManager manager = null;

    private StorageManager() {
        tables = new HashMap<>();
    }

    public static StorageManager getInstance() {
        if (manager == null) {
            manager = new StorageManager();
        }
        return manager;
    }

    public Storage queryTable(String tableName) {
        return tables.get(tableName);
    }

    public void putTable(String tableName, Storage storage) {
        tables.put(tableName, storage);
    }

}
