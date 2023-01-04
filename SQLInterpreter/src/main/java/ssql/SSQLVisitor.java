package ssql;

import ssql.gen.SQLBaseVisitor;
import ssql.gen.SQLParser;

public class SSQLVisitor extends SQLBaseVisitor {

    @Override
    public String visitQuery(SQLParser.QueryContext ctx) {
        return "";
    }

}
