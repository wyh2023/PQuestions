package ssql.gen;

// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SQLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(SQLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(SQLParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#where}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhere(SQLParser.WhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#andPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndPredicate(SQLParser.AndPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#orPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrPredicate(SQLParser.OrPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#negPredicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegPredicate(SQLParser.NegPredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(SQLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#andPred}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndPred(SQLParser.AndPredContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(SQLParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SQLParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(SQLParser.BooleanValueContext ctx);
}