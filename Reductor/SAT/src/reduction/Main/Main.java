package reduction.Main;

import reduction.Antlr.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        try{
            String inputFile = null;
            if ( args.length>0 ) {
                inputFile = args[0];
            }
            InputStream is = System.in;
            if ( inputFile!=null ) {
                is = new FileInputStream(inputFile);
            }

            CharStream input = CharStreams.fromStream(is);
            SatLexer lexer = new SatLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            SatParser parser = new SatParser(tokens);

            ParseTree tree = parser.document();

            SatVisitor eval = new SatVisitor();


            System.out.println(eval.visit(tree));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
