parser grammar SatParser;

@parser::header {
    import java.lang.Math;
}

@parser::members {

    private int xsat;
    private int numNewVariables=0;
    private int numNewClauses=0;

    public SatParser(TokenStream input, int xsatIn){
        this(input);
        this.xsat = xsatIn;
    }

    public int getNewVariables(){
        return this.numNewVariables;
    }
    public int getNewClauses(){
        return this.numNewClauses;
    }
}

options { tokenVocab=SatLexer; }

document    :   COMMENT_BREAK* commentary*  header clause+ BREAK*;
//document    :   header clause+;
commentary  :   COMMENT COMMENT_BREAK+;

header      :   'p' 'cnf' NUMBER NUMBER;

clause
locals [int i=0]
            :   (BREAK+

                (NUMBER{
                    $i++;
                })+

                ('0')?){
                    if($i<this.xsat){
                        this.numNewVariables = this.numNewVariables + this.xsat - $i;
                        this.numNewClauses = this.numNewClauses + (int)Math.pow(2,this.xsat - $i);
                    }
                    else{
                        this.numNewVariables = this.numNewVariables + $i - this.xsat;
                        this.numNewClauses = this.numNewClauses + $i - this.xsat + 1;
                    }
                }
                ;

