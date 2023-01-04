package ssql.gen;

// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(SQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(SQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnList(SQLParser.ColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnList(SQLParser.ColumnListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(SQLParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(SQLParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#andPredicate}.
	 * @param ctx the parse tree
	 */
	void enterAndPredicate(SQLParser.AndPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#andPredicate}.
	 * @param ctx the parse tree
	 */
	void exitAndPredicate(SQLParser.AndPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#orPredicate}.
	 * @param ctx the parse tree
	 */
	void enterOrPredicate(SQLParser.OrPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#orPredicate}.
	 * @param ctx the parse tree
	 */
	void exitOrPredicate(SQLParser.OrPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#negPredicate}.
	 * @param ctx the parse tree
	 */
	void enterNegPredicate(SQLParser.NegPredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#negPredicate}.
	 * @param ctx the parse tree
	 */
	void exitNegPredicate(SQLParser.NegPredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SQLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SQLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#andPred}.
	 * @param ctx the parse tree
	 */
	void enterAndPred(SQLParser.AndPredContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#andPred}.
	 * @param ctx the parse tree
	 */
	void exitAndPred(SQLParser.AndPredContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(SQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(SQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SQLParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(SQLParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(SQLParser.BooleanValueContext ctx);
}