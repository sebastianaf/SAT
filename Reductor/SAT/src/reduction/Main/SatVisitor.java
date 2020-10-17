package reduction.Main;
import org.antlr.v4.runtime.tree.TerminalNode;
import reduction.Antlr.SatParser;
import reduction.Antlr.SatParserBaseVisitor;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOfRange;

public class SatVisitor extends SatParserBaseVisitor <String> {

    private int max = 0;
    private final int xsat;
    private final int numNewVariables;
    private final int numNewClauses;

    public SatVisitor(int xsatIn, int numNewVariablesIn, int numNewClausesIn){
        this.xsat = xsatIn;
        this.numNewVariables = numNewVariablesIn;
        this.numNewClauses = numNewClausesIn;
    }

    @Override
    public String visitDocument(SatParser.DocumentContext ctx) {
        String document = "";
        //visit commentaries
        List<SatParser.CommentaryContext> comments = ctx.commentary();

        for(SatParser.CommentaryContext comment: comments){
            document = document.concat(visit(comment));
        }

        document = document.concat("c this problem was reduced to ").concat(String.valueOf(this.xsat)).concat("-sat\n").concat(visit(ctx.header())).concat("\n");

        List<SatParser.ClauseContext> clauses = ctx.clause();
        //visit clauses to reduce
        for (SatParser.ClauseContext clause: clauses){
            document = document.concat(visit(clause));
        }
        //cambio de cnf y comentarios por nuevos parametros del sat

        return document;
    }

    @Override
    public String visitCommentary(SatParser.CommentaryContext ctx) {

        return ctx.getText();
    }

    @Override
    public String visitHeader(SatParser.HeaderContext ctx) {
        int oldNumVariables = Integer.parseInt(ctx.NUMBER(0).getText());
        String header = "p cnf ".concat(Integer.toString(oldNumVariables+this.numNewVariables)).concat(" ").concat(Integer.toString(this.numNewClauses));
        this.max = Integer.parseInt(ctx.NUMBER(0).getText()) + 1;
        return header;
    }

    @Override
    public String visitClause(SatParser.ClauseContext ctx) {
        String clause = "";
        List<TerminalNode> numbers = ctx.NUMBER();

        String auxClause = "";
        for(TerminalNode number: numbers) {
            auxClause = auxClause.concat(number.getText()).concat(" ");
        }
        // si el tamaño de la clausula es menor o igual al sat destino
        if (numbers.size() <= this.xsat){
            //creo 2^{x-k} clausulas
            for (int newClause = 0; newClause < Math.pow(2,this.xsat - numbers.size()); newClause+= 1){
                //combinaciones de variables en negativos y positivos para cada clausula
                String combination = Integer.toBinaryString(newClause);
                while(combination.length() < (this.xsat - numbers.size()))
                    combination = "0" + combination;
                //preparando la concatenacion de la clausula
                clause = clause.concat(auxClause);
                //creo x-k variables
                for (int newVariable = 0; newVariable < this.xsat - numbers.size(); newVariable+= 1){
                    //si de la combinacion creada antes es uno, la variable es negativa
                    if (combination.charAt(newVariable) == '1'){
                        clause = clause.concat("-");
                    }
                    //concateno la variable nueva
                    clause = clause.concat(String.valueOf(this.max + newVariable)).concat(" ");
                }
                clause = clause.concat("0 \n");
            }
            //seteo mi siguiente valor maximo como el anterior mas la cantidad de variables agregadas
            this.max = this.max + this.xsat - numbers.size();
        }else {
            // si el tamaño de la clausula es mayor al sat destino
            if (numbers.size() > this.xsat) {
                int lastindex = 0;
                String[] auxVariables = {};
                String[] piece = {};
                String strpiece = "";
                auxVariables = auxClause.split(" ");
                //obtengo las substrings que van a generar las nuevas clausulas
                // substring de la primera clausula
                piece = copyOfRange(auxVariables, lastindex, lastindex + this.xsat - 1);
                strpiece = String.join(" ", piece);
                clause = clause.concat(strpiece).concat(" ").concat(String.valueOf(this.max)).concat("\n");
                lastindex = lastindex + 2;
                //creo k-x+1 clausulas
                for (int newClause = 2; newClause < numbers.size() - this.xsat + 1; newClause += 1) {
                    //clausulas intermedias, no tengo en cuenta inicial ni final
                    piece = copyOfRange(auxVariables, lastindex, lastindex + this.xsat - 2);
                    strpiece = String.join(" ", piece);
                    clause = clause.concat("-").concat(String.valueOf(this.max)).concat(" ").concat(strpiece).concat(" ").concat(String.valueOf(this.max + 1));
                    this.max = this.max + 1;
                    lastindex = lastindex + 1;
                    clause = clause.concat("0 \n");
                }
                //substring de la ultima clausula
                piece = copyOfRange(auxVariables, lastindex, lastindex + this.xsat - 1);
                strpiece = String.join(" ", piece);
                clause = clause.concat("-").concat(String.valueOf(this.max)).concat(" ").concat(strpiece).concat("\n");
                this.max = this.max + 1;
            }
        }
        return clause;
    }
}

