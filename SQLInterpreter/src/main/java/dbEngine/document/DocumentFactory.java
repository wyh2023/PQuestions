package dbEngine.document;

public abstract class DocumentFactory {

    public abstract Document produce(String[] cols, String[] docs);

}
