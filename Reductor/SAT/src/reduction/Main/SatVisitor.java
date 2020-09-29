package reduction.Main;
import org.antlr.v4.runtime.tree.TerminalNode;
import reduction.Antlr.SatParser;
import reduction.Antlr.SatParserBaseVisitor;

import java.util.List;

public class  SatVisitor extends SatParserBaseVisitor <String> {

    private int max = 0;

    @Override
    public String visitDocument(SatParser.DocumentContext ctx) {
        String document = "";

        List<SatParser.CommentaryContext> comments = ctx.commentary();

        for(SatParser.CommentaryContext comment: comments){
            document = document.concat(visit(comment));
        }

        document = document.concat(visit(ctx.header())).concat("\n");

        List<SatParser.ClauseContext> clauses = ctx.clause();

        for (SatParser.ClauseContext clause: clauses){
            document = document.concat(visit(clause));
        }

        return document;
    }

    @Override
    public String visitCommentary(SatParser.CommentaryContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitHeader(SatParser.HeaderContext ctx) {
        String header = "p cnf ";
        header = header.concat(ctx.NUMBER(0).getText().concat(" 51"));
        this.max = Integer.parseInt(ctx.NUMBER(0).getText());
        return header;
    }

    @Override
    public String visitClause(SatParser.ClauseContext ctx) {
        String clause = "";
        List<TerminalNode> numbers = ctx.NUMBER();

        String auxClause = "";
        for(TerminalNode number: numbers){
            auxClause = auxClause.concat(number.getText()).concat(" ");
        }

        clause = clause.concat(auxClause).concat(" xD\n");
        clause = clause.concat(auxClause).concat(" -xD\n");

        return clause;
    }
}
