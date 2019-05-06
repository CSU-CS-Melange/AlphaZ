lexer grammar Lexer;

WS  :   (' '|'\t')+ {skip();} ;       
ID  :   ('_'|'a'..'z'|'A'..'Z') ('_'|'0'..'9'|'a'..'z'|'A'..'Z')*   ; 
INT :   '0'..'9'+ ;

NEWLINE:'\r'? '\n' ;
