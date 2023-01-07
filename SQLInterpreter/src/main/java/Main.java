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

import java.io.File;

public class Main {

    public static SSQLVisitor visitor = new SSQLVisitor();
    public static SSQLErrorListener errorListener = new SSQLErrorListener();

    public static void main(String[] args) {
        String textStr = "select Name,City from Simple where City = Beijing";

        System.out.println();
        System.out.println(textStr);
        System.out.println();

        SQLLexer lexer = new SQLLexer(CharStreams.fromString(textStr));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        parser.addErrorListener(errorListener);

        EngineOptionsHandler handler = new EngineOptionsHandler();
        handler.resolve("src/main/resources/ssql.yml");
        SSQLEngine engine = SSQLEngine.getInstance();
        File file = new File("src/main/resources/ssql/Simple.ssql");
        engine.input(file);

        QueryInfo info = (QueryInfo) parser.query().accept(visitor);
        QueryChecker checker = new QueryChecker();
        if (!checker.check(info)) return;

        engine.execute(info);
    }

}
