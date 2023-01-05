import dbEngine.EngineOptionsHandler;
import dbEngine.SSQLEngine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ssql.QueryChecker;
import ssql.QueryInfo;
import ssql.SSQLErrorListener;
import ssql.SSQLVisitor;
import ssql.gen.SQLLexer;
import ssql.gen.SQLParser;

import java.io.File;

public class Main {

    public static SSQLVisitor visitor = new SSQLVisitor();
    public static SSQLErrorListener errorListener = new SSQLErrorListener();

    public static void main(String[] args) {
        String textStr = "select C,C2 from T where P = 1";

        System.out.println(textStr);
        System.out.println();

        SQLLexer lexer = new SQLLexer(CharStreams.fromString(textStr));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        parser.addErrorListener(errorListener);

        QueryInfo info = (QueryInfo) parser.query().accept(visitor);
        QueryChecker checker = new QueryChecker();
        checker.check(info);

        EngineOptionsHandler handler = new EngineOptionsHandler();
        handler.resolve("src/main/resources/ssql.yml");
        SSQLEngine engine = SSQLEngine.getInstance();
        File file = new File("src/main/resources/ssql/Simple.ssql");
        engine.input(file);
        engine.output("Simple");
    }

}
