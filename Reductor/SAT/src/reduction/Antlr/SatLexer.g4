lexer grammar SatLexer;

COMMENT         :   'c' ~('\r' | '\n')* ;
COMMENT_BREAK   :   '\r'? '\n';
WS_COMMENT      :   [ \t]+                      -> skip ;
P               :   'p'                 -> pushMode (HEADER);

// ----------------- Everything AFTER p ---------------------
mode HEADER;
CNF     :   'cnf';

NUMBER  :   ('-')? [1-9]+ [0-9]* ;
ZERO    :   '0' ;
BREAK   :   '\r'? '\n' ;
WS      :   [ \t]+                      -> skip ;