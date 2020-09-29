lexer grammar SatLexer;

COMMENT         :   'c' ~('\r' | '\n')* ;

COMMENT_BREAK   :   '\r'? '\n';

P               :   'p'                 -> pushMode (HEADER);

// ----------------- Everything AFTER p ---------------------
mode HEADER;
CNF     :   'cnf';

fragment
DIGIT   :   [1-9];

NUMBER  :   ('-')? DIGIT+ ;
ZERO    :   '0' ;
BREAK   :   '\r'? '\n' ;
WS      :   [ \t]+                      -> skip ;