package utils;

import dbEngine.TableCatalog;
import dbEngine.document.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FormatUtil {

    private final List<List<String>> outputs = new ArrayList<>();
    private final List<Integer> size = new ArrayList<>();

    private final Map<String, Integer> index = new HashMap<>();

    private final List<String> columns = new ArrayList<>();

    private StringBuffer sb = null;

    private final int offset = 3;

    public void output(Stream<Document> docs, Stream<String> cols) {
        initSize(cols);
        handleDocs(docs);
        sb = new StringBuffer();
        printBound();
        printContent(columns);
        printBound();
        outputs.forEach(this::printContent);
        printBound();
        sb = null;
    }

    private void initSize(Stream<String> cols) {
        cols.forEach(col -> {
            columns.add(col);
            size.add(col.length() + offset);
        });
        int i = 0;
        for (String col : columns) {
            index.put(col, i);
            i++;
        }
    }

    private void handleDocs(Stream<Document> docs) {
        docs.forEach(doc -> {
            List<String> content = new ArrayList<>();
            for (int i = 0; i < columns.size(); i++) content.add(null);
            doc.retrieve().forEach(entry -> {
                String key = entry.getKey();
                String val = entry.getValue();
                content.set(index.get(key), val);
                int s = val.length() + offset;
                int i = index.get(key);
                if (size.get(i) < s) {
                    size.set(i, s);
                }
            });
            outputs.add(content);
        });
    }

    private void printBound() {
        sb.append("+");
        columns.forEach(col -> {
            int len = size.get(index.get(col));
            sb.append("-".repeat(len))
                    .append("+");
        });
        System.out.println(sb);
        sb.delete(0, sb.length());
    }

    private void printContent(List<String> contents) {
        sb.append("|");
        for (int i = 0; i < contents.size(); i++) {
            int len = size.get(i);
            String str = contents.get(i);
            sb.append(str)
                    .append(" ".repeat(len - str.length()))
                    .append("|");
        }
        System.out.println(sb);
        sb.delete(0, sb.length());
    }

    public static void printTableNames() {
        TableCatalog tableCatalog = TableCatalog.getInstance();
        List<Integer> size = new ArrayList<>();
        size.add(9);
        List<String> tableNames = new ArrayList<>();
        tableCatalog.traverseTables()
                .forEach(tableName -> {
                    size.set(0, Math.max(tableName.length(), size.get(0) + 3));
                    tableNames.add(tableName);
                });
        if (tableNames.size() == 0) {
            return;
        }
        System.out.print("+");
        System.out.print("-".repeat(Math.max(0, size.get(0))));
        System.out.println("+");
        System.out.print("|");
        System.out.print("Tables" + " ".repeat(Math.max(0, size.get(0) - 6)));
        System.out.println("|");
        System.out.print("+");
        System.out.print("-".repeat(Math.max(0, size.get(0))));
        System.out.println("+");
        for (String tableName : tableNames) {
            System.out.print("|");
            System.out.print(tableName + " ".repeat(Math.max(0, size.get(0) - tableName.length())));
            System.out.println("|");
        }
        System.out.print("+");
        System.out.print("-".repeat(Math.max(0, size.get(0))));
        System.out.println("+");
    }

}

