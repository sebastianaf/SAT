parser grammar SatParser;

@parser::members {
    private int numNewVariables=0;
    private int numNewClauses = 0;

    public int getNewVariables(){
        return this.numNewVariables;
    }
    public int getNewClauses(){
        return this.numNewClauses;
    }
}

options { tokenVocab=SatLexer; }

document    :   COMMENT_BREAK* commentary*  header clause+ BREAK*;

commentary  :   COMMENT COMMENT_BREAK+;

header      :   'p' 'cnf' NUMBER NUMBER;

clause      :   BREAK+ NUMBER+ ('0')?;


