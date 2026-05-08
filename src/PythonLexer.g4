lexer grammar PythonLexer;
@header {
package antlrPython;
import java.util.*;

}
tokens { INDENT, DEDENT }
@members {
    java.util.Stack<Integer> indents = new java.util.Stack<>();
    int opened = 0;
}

// ---------------- INDENTATION HANDLING ------------------
NEWLINE : ('\r'? '\n')  SPACES?;
WS : [ \t]+ -> channel(HIDDEN) ;
SPACES: [ \t]+ ;
LINE_JOIN : '\\' [ \t]* ('\r'? '\n') -> skip ;

// ---------------- KEYWORDS ------------------
DEF      : 'def';
RETURN   : 'return';
RAISE    : 'raise';


FROM     : 'from';
IMPORT   : 'import';
NONLOCAL : 'nonlocal';
AS       : 'as';
GLOBAL   : 'global';
ASSERT   : 'assert';
IF       : 'if';
ELIF     : 'elif';
ELSE     : 'else';
WHILE    : 'while';
FOR      : 'for';
IN       : 'in';
TRY      : 'try';
NONE     : 'None';
FINALLY  : 'finally';
WITH     : 'with';
EXCEPT   : 'except';
LAMBDA   : 'lambda';
OR       : 'or';
AND      : 'and';
NOT      : 'not';
IS       : 'is';
CLASS    : 'class';
YIELD    : 'yield';
DEL      : 'del';
PASS     : 'pass';
CONTINUE : 'continue';
BREAK    : 'break';
ASYNC    : 'async';
AWAIT    : 'await';
PRINT    : 'print';
EXEC     : 'exec';
TRUE     : 'True';
FALSE    : 'False';

// ---------------- OPERATORS ------------------
ELLIPSIS           : '...';
REVERSE_QUOTE      : '`';
POWER              : '**';
XOR                : '^';
AND_OP             : '&';
LEFT_SHIFT         : '<<';
RIGHT_SHIFT        : '>>';
MOD                : '%';
IDIV               : '//';
NOT_OP             : '~';
EQUALS             : '==';
GT_EQ              : '>=';
LT_EQ              : '<=';

NOT_EQ_2           : '!=';
AT                 : '@';
ARROW              : '->';
ADD_ASSIGN         : '+=' ;
SUB_ASSIGN         : '-=' ;
MULT_ASSIGN        : '*=' ;
AT_ASSIGN          : '@=' ;
DIV_ASSIGN         : '/=' ;
MOD_ASSIGN         : '%=' ;
AND_ASSIGN         : '&=' ;
OR_ASSIGN          : '|=' ;
XOR_ASSIGN         : '^=' ;
LEFT_SHIFT_ASSIGN  : '<<=' ;
RIGHT_SHIFT_ASSIGN : '>>=' ;
POWER_ASSIGN       : '**=' ;
IDIV_ASSIGN        : '//=' ;

// ---------------- SYMBOLS -------------------
LBRACE     : '{' {opened++;};
RBRACE     : '}' {opened--;};
LPAREN     : '(' {opened++;};
RPAREN     : ')' {opened--;};
LBRACK     : '[' ;
RBRACK     : ']' ;
SEMI       : ';' ;
COLON      : ':' ;
COMMA      : ',' ;
DOT        : '.' ;
EQ         : '=' ;
PLUS       : '+' ;
MINUS      : '-' ;
STAR       : '*' ;
SLASH      : '/' ;
LT         : '<' ;
GT         : '>' ;
PIPE       : '|' ;
UNDERSCORE : '_' ;

// ---------------- STRINGS & NUMBERS ------------------
STRING:
    ([uU] | [fF] [rR]? | [rR] [fF]?)? (SHORT_STRING | LONG_STRING)
    | ([bB] [rR]? | [rR] [bB]) (SHORT_BYTES | LONG_BYTES)
;

DECIMAL_INTEGER : [1-9] [0-9]* | '0'+;
OCT_INTEGER     : '0' [oO] [0-7]+;
HEX_INTEGER     : '0' [xX] [0-9a-fA-F]+;
BIN_INTEGER     : '0' [bB] [01]+;

IMAG_NUMBER  : (EXPONENT_OR_POINT_FLOAT | [0-9]+) [jJ];
FLOAT_NUMBER : EXPONENT_OR_POINT_FLOAT;

// ---------------- COMMENTS -------------------
COMMENT   : '#' ~[\r\n]* -> skip;

// ---------------- IDENTIFIERS ------------------
NAME: ID_START ID_CONTINUE*;

// ---------------- FRAGMENTS -------------------
fragment SHORT_STRING:
    '\'' ('\\' . | ~[\\\r\n'])* '\''
  | '"'  ('\\' . | ~[\\\r\n"])* '"'
;

fragment LONG_STRING: '\'\'\'' LONG_STRING_ITEM*? '\'\'\'' | '"""' LONG_STRING_ITEM*? '"""';
fragment LONG_STRING_ITEM: ~'\\' | '\\' .;

fragment RN: '\r'? '\n';

fragment EXPONENT_OR_POINT_FLOAT:
      POINT_FLOAT [eE] [+-]? [0-9]+
    | [0-9]+ [eE] [+-]? [0-9]+
    | POINT_FLOAT
;

fragment POINT_FLOAT:
      [0-9]* '.' [0-9]+
    | [0-9]+ '.'
;

fragment SHORT_BYTES:
    '\'' (SHORT_BYTES_CHAR_NO_SINGLE_QUOTE | BYTES_ESCAPE_SEQ)* '\''
  | '"'  (SHORT_BYTES_CHAR_NO_DOUBLE_QUOTE | BYTES_ESCAPE_SEQ)* '"'
;

fragment LONG_BYTES:
      '\'\'\'' LONG_BYTES_ITEM*? '\'\'\''
    | '"""' LONG_BYTES_ITEM*? '"""'
;

fragment LONG_BYTES_ITEM: LONG_BYTES_CHAR | BYTES_ESCAPE_SEQ;

fragment SHORT_BYTES_CHAR_NO_SINGLE_QUOTE:
    [\u0000-\u0009]
  | [\u000B-\u000C]
  | [\u000E-\u0026]
  | [\u0028-\u005B]
  | [\u005D-\u007F]
;

fragment SHORT_BYTES_CHAR_NO_DOUBLE_QUOTE:
    [\u0000-\u0009]
  | [\u000B-\u000C]
  | [\u000E-\u0021]
  | [\u0023-\u005B]
  | [\u005D-\u007F]
;

fragment LONG_BYTES_CHAR: [\u0000-\u005B] | [\u005D-\u007F];
fragment BYTES_ESCAPE_SEQ: '\\' [\u0000-\u007F];

fragment ID_CONTINUE: ID_START | [0-9] | [\u0300-\u036F];
fragment ID_START: '_' | [a-zA-Z];