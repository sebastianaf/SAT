package reduction.Main;

import reduction.Antlr.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File folderInstancias = new File("../InstanciasSAT");
            File [] files = folderInstancias.listFiles();
            if(files.length==0){
                System.out.println(".JAR's BAD UBICATION OR EMPTY FOLDER");
            }

            for (int i = 0;i<files.length;i++){
                System.out.println(files[i].getName());
            }

            //Default sat to reduce
            int xsat = 3;
            if ( args.length>0 ) {
                try{
                    xsat = Integer.parseInt(args[0]);
                }catch (Error e){
                    System.out.println("invalid X specified to reduce,\n using default "+String.valueOf(xsat)+"-SAT");
                }
            }
            int i = 0;
            while(i<files.length){
                System.out.println(i);
                String inputFile = files[i].getName();
                InputStream is = System.in;
                if ( inputFile!=null ) {
                    is = new FileInputStream("../InstanciasSAT/"+inputFile);
                }
                System.out.println("../InstanciasSAT/"+inputFile);

                CharStream input = CharStreams.fromStream(is);
                SatLexer lexer = new SatLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                //parser will save the new variables and clauses
                SatParser parser = new SatParser(tokens, xsat);
                ParseTree tree = parser.document();
                SatVisitor eval = new SatVisitor(xsat, parser.getNewVariables(), parser.getNewClauses());


                FileWriter outputFile = null;
                PrintWriter pw = null;
                try{
                    String newFileName = files[i].getName().substring(0,files[i].getName().length()-4)+"_to_"+String.valueOf(xsat)+"_SAT.cnf";
                    outputFile = new FileWriter("../X-SAT/"+newFileName);
                    pw = new PrintWriter(outputFile);
                    System.out.println("../X-SAT/"+newFileName);
                    String outStr = eval.visit(tree);
                    //System.out.println(outStr);
                    pw.println(outStr);


                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                } finally {
                    try {
                        if (null != outputFile)
                            outputFile.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        break;
                    }
                    i++;
                }
            }


        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}
