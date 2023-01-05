package ssql;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import ssql.gen.SQLBaseVisitor;
import ssql.gen.SQLParser;

import java.util.ArrayList;
import java.util.List;

public class SSQLVisitor extends SQLBaseVisitor {

    public static void printError(String msg) {
        System.err.println(msg);
    }

    @Override
    public QueryInfo visitQuery(SQLParser.QueryContext ctx) {
        int flag = 0;
        String table = visitTable(ctx.table());
        List<String> columnList = visitColumnList(ctx.columnList());
        return new QueryInfo(columnList, table);
    }

    @Override
    public Object visitWhere(SQLParser.WhereContext ctx) {
        return super.visitWhere(ctx);
    }

    @Override
    public List<String> visitColumnList(SQLParser.ColumnListContext ctx) {
        List<String> ret = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            if (child instanceof SQLParser.ColumnListContext colCtx) {
                ret.addAll(visitColumnList(colCtx));
            } else if (!child.getText().equals(",")) {
                ret.add(child.getText());
            }
        }
        return ret;
    }

    @Override
    public String visitTable(SQLParser.TableContext ctx) {
        return resolveIdentifier(ctx.IDENTIFIER());
    }

    private String resolveIdentifier(TerminalNode identifier) {
        return identifier.getText();
    }

}
