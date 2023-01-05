package dbEngine.storage;

public abstract class StorageFactory {

    public abstract Storage produce(String tableName);

}
