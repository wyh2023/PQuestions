package dbEngine.document;

public class SSQLMapDocFactory extends DocumentFactory {

    @Override
    public Document produce(String[] cols, String[] docs) {
        int len = cols.length;
        return new SSQLMapDocument(cols, docs, len);
    }
}
