package ssql;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import ssql.gen.SQLBaseVisitor;
import ssql.gen.SQLParser;
import ssql.info.predicate.AndSet;
import ssql.info.predicate.EqSet;
import ssql.info.predicate.OrSet;
import ssql.info.predicate.Predicate;
import ssql.info.predicate.PredicateSet;
import ssql.info.QueryInfo;

import java.util.ArrayList;
import java.util.List;

public class SSQLVisitor extends SQLBaseVisitor {

    public static void printError(String msg) {
        System.err.println(msg);
    }

    @Override
    public QueryInfo visitQuery(SQLParser.QueryContext ctx) {
        String table = visitTable(ctx.table());
        List<String> columnList = visitColumnList(ctx.columnList());
        PredicateSet tree = visitPredicate(ctx.predicate());
        return new QueryInfo(columnList, table, tree.getAllPredicate());
    }

    @Override
    public PredicateSet visitPredicate(SQLParser.PredicateContext ctx) {
        PredicateSet ret;
        if (ctx.children.size() == 2) {
            ret = visitPredicate((SQLParser.PredicateContext) ctx.getChild(1));
        } else {
            ParseTree left = ctx.getChild(0);
            ParseTree operator = ctx.getChild(1);
            ParseTree right = ctx.getChild(2);
            if (operator.getText().equals("=")) {
                Predicate predicate = new Predicate(left.getText(), right.getText(), true);
                ret = new EqSet(predicate);
            } else if (operator.getText().equals("and")) {
                PredicateSet leftSet = visitPredicate((SQLParser.PredicateContext) left);
                PredicateSet rightSet = visitPredicate((SQLParser.PredicateContext) right);
                ret = new AndSet(leftSet, rightSet);
            } else {
                PredicateSet leftSet = visitPredicate((SQLParser.PredicateContext) left);
                PredicateSet rightSet = visitPredicate((SQLParser.PredicateContext) right);
                ret = new OrSet(leftSet, rightSet);
            }
        }
        return ret;
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
