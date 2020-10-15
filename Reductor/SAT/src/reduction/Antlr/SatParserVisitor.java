// Generated from C:/Users/57310/Documents/Github/SAT/src/reduction/Antlr\SatParser.g4 by ANTLR 4.8
package reduction.Antlr;

    import java.lang.Math;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SatParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SatParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(SatParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SatParser#commentary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommentary(SatParser.CommentaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SatParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(SatParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link SatParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(SatParser.ClauseContext ctx);
}