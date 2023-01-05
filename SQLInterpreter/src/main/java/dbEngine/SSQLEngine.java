package dbEngine;

import dbEngine.document.Document;
import dbEngine.document.DocumentFactory;
import dbEngine.document.SSQLMapDocFactory;
import dbEngine.storage.MapDocStorageFactory;
import dbEngine.storage.Storage;
import dbEngine.storage.StorageFactory;
import dbEngine.storage.StorageManager;
import exception.UnsupportedFileException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SSQLEngine {

    private static SSQLEngine engine;

    private final TableCatalog tables = TableCatalog.getInstance();

    private final ColumnCatalog cols = ColumnCatalog.getInstance();

    private final StorageManager storageManager = StorageManager.getInstance();

    private final DocumentFactory docFactory;

    private final StorageFactory storageFactory;

    /**
     * Default Engine Constructor.
     */
    private SSQLEngine() {
        docFactory = new SSQLMapDocFactory();
        storageFactory = new MapDocStorageFactory();
    }
    private SSQLEngine(EngineOptionsHandler handler) {
        docFactory = handler.getDocFactory();
        storageFactory = handler.getStorageFactory();
    }

    public static SSQLEngine getInstance() {
        if (engine == null) {
            engine = new SSQLEngine();
        }
        return engine;
    }

    public void input(File ssqlFile) {
        String fileName = ssqlFile.getName();
        if (!fileName.endsWith(".ssql")) {
            throw new UnsupportedFileException("Unsupported SSQL File");
        }

        String tableName = fileName.substring(0, fileName.length() - 5);
        if (!tables.isTableExist(tableName)) {
            try {
                FileInputStream stream = new FileInputStream(ssqlFile);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line = reader.readLine();
                tables.addTable(tableName);
                String[] columns = line.split(",");
                cols.putColumn(tableName, columns);
                Storage storage = storageFactory.produce(tableName);
                while ((line = reader.readLine()) != null) {
                    Document doc = docFactory.produce(columns, line.split(","));
                    storage.insert(doc);
                }
                storageManager.putTable(tableName, storage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int check = 1;
    }

}
