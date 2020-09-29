// Generated from C:/Users/57310/Documents/Github/SAT/src/reduction/Antlr\SatParser.g4 by ANTLR 4.8
package reduction.Antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SatParser}.
 */
public interface SatParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SatParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(SatParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SatParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(SatParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SatParser#commentary}.
	 * @param ctx the parse tree
	 */
	void enterCommentary(SatParser.CommentaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SatParser#commentary}.
	 * @param ctx the parse tree
	 */
	void exitCommentary(SatParser.CommentaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SatParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(SatParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SatParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(SatParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SatParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(SatParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SatParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(SatParser.ClauseContext ctx);
}