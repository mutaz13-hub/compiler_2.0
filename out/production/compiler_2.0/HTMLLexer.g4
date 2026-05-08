lexer grammar HTMLLexer;
@header{
package antlrHTML;
}
channels {
    ERROR
}

LBRACE     : '{' ;
RBRACE     : '}' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
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
PIPE       : '|' ;
UNDERSCORE : '_' ;
QUESTION   : '?' ;
AND        : 'and' ;
OR         : 'or' ;
TAG_OPEN   : '<';
TAG_CLOSE  : '>';
HASH       : '#' ;
TILDE      : '~' ;
TILDE_EQUALS : '~=' ;
PIPE_EQUALS  : '|=' ;
CARET_EQUALS : '^=' ;
DOLLAR_EQUALS : '$=' ;
STAR_EQUALS  : '*=' ;
DOUBLE_COLON : '::' ;
NOT          : 'not' ;
NUMBER       : '-'? [0-9]+ ( '.' [0-9]+ )? ( [a-z%]+ )?
             | '-'? '.' [0-9]+ ( [a-z%]+ )? ;
VAR          : '--' NMSTART NMCHAR* ;
ID: TAG_NameStartChar TAG_NameChar*;
WS: (' ' | '\t' | '\r'? '\n')+->skip;
NEWLINE: '\r\n';
DOUBLE_QUOTE_STRING: '"' ~[<"]* '"';
HTML_COMMENT: '<!--' .*? '-->'->skip;
STYLE_COMMENT      : '/*' .*? '*/' -> skip ;
IMPORTANT    : '!' [ \t]* 'important' ;
URL          : 'url' LPAREN ;
AT_RULE      : '@' (ID | '-')+ ;
IDENT        : '-'? NMSTART NMCHAR* ;
VAR_START : '{{' ;
VAR_END : '}}' ;
BLOCK_START : '{%' ;
BLOCK_END : '%}' ;
COMMENT_START : '{#' ;
COMMENT_END : '#}' ;
IF : 'if' ;
ELIF : 'elif' ;
ELSE : 'else' ;
ENDIF : 'endif' ;
FOR : 'for' ;
IN : 'in' ;
ENDFOR : 'endfor' ;
SET : 'set' ;
BLOCK : 'block' ;
ENDBLOCK : 'endblock' ;
INCLUDE : 'include' ;
EXTENDS : 'extends' ;

//////////////fragment//////////////
fragment TAG_NameChar:
    TAG_NameStartChar
    | '-'
    | '_'
    | '.'
    | DIGIT
    | '\u00B7'
    | '\u0300' ..'\u036F'
    | '\u203F' ..'\u2040'
;
fragment TAG_NameStartChar:
    [a-zA-Z]
    | '\u2070' ..'\u218F'
    | '\u2C00' ..'\u2FEF'
    | '\u3001' ..'\uD7FF'
    | '\uF900' ..'\uFDCF'
    | '\uFDF0' ..'\uFFFD'
;
fragment DIGIT: [0-9];
fragment IDENT_START : [a-zA-Z_] | [\u0080-\uFFFF] ;
fragment IDENT_CHAR : [a-zA-Z0-9\-_] | [\u0080-\uFFFF] ;
fragment NMSTART : IDENT_START | '\\' . ;
fragment NMCHAR : IDENT_CHAR | '\\' . ;
