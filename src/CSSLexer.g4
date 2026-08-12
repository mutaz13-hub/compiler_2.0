lexer grammar CSSLexer;
@header { package antlrCSS; }

// ---------------- Skipped ----------------
WS            : [ \t\r\n]+ -> skip ;
COMMENT       : '/*' .*? '*/' -> skip ;

// ---------------- Structural ----------------
LBRACE        : '{' ;
RBRACE        : '}' ;
COLON         : ':' ;
SEMI          : ';' ;
COMMA         : ',' ;
LPAREN        : '(' ;
RPAREN        : ')' ;
GT            : '>' ;
PLUS          : '+' ;
TILDE         : '~' ;
STAR          : '*' ;
DOT           : '.' ;
HASH          : '#' ;
PERCENT       : '%' ;
AMP           : '&' ;
BANG          : '!' ;
ATKEYWORD     : '@' IDENT ;

// ---------------- Literals ----------------
STRING        : '"' (~["\r\n])* '"' | '\'' (~['\r\n])* '\'' ;
NUMBER        : DIGIT+ ('.' DIGIT+)? | '.' DIGIT+ ;
HEXCOLOR      : '#' HEXDIGIT+ ;
UNIT          : 'px' | 'em' | 'rem' | 'vh' | 'vw' | '%' | 's' | 'ms' | 'deg' ;
URL           : 'url(' .*? ')' ;

IDENT         : ('-')? NAMESTART NAMECHAR* ;

fragment NAMESTART : [a-zA-Z_] ;
fragment NAMECHAR  : [a-zA-Z0-9_-] ;
fragment DIGIT      : [0-9] ;
fragment HEXDIGIT    : [0-9a-fA-F] ;

CLASS_SELECTOR : '.' IDENT ;
ID_SELECTOR    : '#' IDENT ;
PSEUDO         : ':' ':'? IDENT ;
ATTR_OPEN      : '[' ;
ATTR_CLOSE     : ']' ;
EQUALS         : '=' ;

ANY_CHAR      : . ;
