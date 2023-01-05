package antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import ssql.QueryInfo;
import ssql.SSQLErrorListener;
import ssql.SSQLVisitor;
import ssql.gen.SQLLexer;
import ssql.gen.SQLParser;

public class AntlrTest {

    public SSQLVisitor visitor = new SSQLVisitor();
    public SSQLErrorListener errorListener = new SSQLErrorListener();

    @Test
    public void simpleTest() {
        String textStr = "select C,C2 from T where P = 1";

        SQLLexer lexer = new SQLLexer(CharStreams.fromString(textStr));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);
        parser.addErrorListener(errorListener);

        QueryInfo ret = (QueryInfo) parser.query().accept(visitor);

    }

}
