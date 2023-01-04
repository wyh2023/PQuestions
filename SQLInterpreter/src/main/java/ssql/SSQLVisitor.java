package ssql;

import ssql.gen.SQLBaseVisitor;
import ssql.gen.SQLParser;

public class SSQLVisitor extends SQLBaseVisitor {

    @Override
    public String visitQuery(SQLParser.QueryContext ctx) {
        int flag = 0;
        return "";
    }

    @Override
    public Object visitTable(SQLParser.TableContext ctx) {
        return super.visitTable(ctx);
    }
}
