package dbEngine.storage;

public class MapDocStorageFactory extends StorageFactory{

    @Override
    public Storage produce(String tableName) {
        return new MapDocStorage(tableName);
    }
}
