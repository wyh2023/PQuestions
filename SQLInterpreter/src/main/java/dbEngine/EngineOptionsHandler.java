package dbEngine;

import dbEngine.document.DocumentFactory;
import dbEngine.document.SSQLMapDocFactory;
import dbEngine.storage.MapDocStorage;
import dbEngine.storage.MapDocStorageFactory;
import dbEngine.storage.Storage;
import dbEngine.storage.StorageFactory;
import org.yaml.snakeyaml.Yaml;
import utils.YamlUtil;

import java.util.Map;

public class EngineOptionsHandler {

    private DocumentFactory docFactory = null;

    private StorageFactory storageFactory = null;

    public void resolve(String fileName) {
        YamlUtil yamlUtil = new YamlUtil();
        Map<String, Object> options = yamlUtil.parseYaml(fileName);
        resolveOptions(options);
    }

    private void resolveOptions(Map<String, Object> options) {
        Object docType = options.get("documentType");
        if (docType.equals("map")) {
            docFactory = new SSQLMapDocFactory();
            storageFactory = new MapDocStorageFactory();
        }
    }

    public DocumentFactory getDocFactory() {
        if (docFactory == null) {
            throw new RuntimeException("Unfounded Document Type!");
        }
        return docFactory;
    }

    public StorageFactory getStorageFactory() {
        if (storageFactory == null) {
            throw new RuntimeException("Unfounded Document Type!");
        }
        return storageFactory;
    }

}
