import dbEngine.EngineOptionsHandler;
import dbEngine.SSQLEngine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ssql.QueryChecker;
import ssql.info.QueryInfo;
import ssql.SSQLErrorListener;
import ssql.SSQLVisitor;
import ssql.gen.SQLLexer;
import ssql.gen.SQLParser;
import utils.FormatUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static SSQLVisitor visitor = new SSQLVisitor();
    public static SSQLErrorListener errorListener = new SSQLErrorListener();

    public static String PROJECT_DIR = System.getProperty("user.dir");

    public static SSQLEngine initEngine() {
        EngineOptionsHandler handler = new EngineOptionsHandler();
        handler.resolve("src/main/resources/ssql.yml");
        return SSQLEngine.getInstance();
    }

    public static SQLParser initParser(String input) {
        SQLLexer lexer = new SQLLexer(CharStreams.fromString(input));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        parser.addErrorListener(errorListener);
        return parser;
    }

    public static void printHelp() {
        System.out.println("""
                usage: [option]

                    -t, --table           checkout into given table
                    -h, --help            information and guide about ssql
                """);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("sSQL> ");

        String line;
        line = in.nextLine();
        SSQLEngine engine = initEngine();
        File file = new File("src/main/resources/ssql");
        for (File child : Objects.requireNonNull(file.listFiles()))
            engine.input(child);

        while (!line.equals("exit")) {

            if (line.equals("show tables")) {
                FormatUtil.printTableNames();
            } else {
                SQLParser parser = initParser(line);
                QueryInfo info = (QueryInfo) parser.query().accept(visitor);
                QueryChecker checker = new QueryChecker();
                if (checker.check(info)) {
                    engine.execute(info);
                }

                // :( Bad Solution to synchronize ERR and OUT streams.
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.print("sSQL> ");
            line = in.nextLine();
        }
        System.out.println("Have a nice day!");
    }

}
