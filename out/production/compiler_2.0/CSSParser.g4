parser grammar CSSParser;
@header { package antlrCSS; }
options { tokenVocab = CSSLexer; }

stylesheet
    : (rule_ | atRule)* EOF
    ;

atRule
    : ATKEYWORD (~(LBRACE | SEMI))* (block_ | SEMI)
    ;

rule_
    : selectorList LBRACE declaration* RBRACE
    ;

selectorList
    : selector (COMMA selector)*
    ;

selector
    : simpleSelector (combinator simpleSelector)*
    ;

combinator
    : GT | PLUS | TILDE
    ;

simpleSelector
    : selectorPart+
    ;

selectorPart
    : IDENT
    | STAR
    | CLASS_SELECTOR
    | ID_SELECTOR
    | PSEUDO
    | ATTR_OPEN IDENT (EQUALS (STRING | IDENT))? ATTR_CLOSE
    ;

declaration
    : property_ COLON value+ BANG? IDENT? SEMI?
    ;

property_
    : IDENT
    ;

value
    : NUMBER UNIT?
    | HEXCOLOR
    | STRING
    | IDENT
    | URL
    | functionCall
    | COMMA
    ;

functionCall
    : IDENT LPAREN (value (COMMA value)*)? RPAREN
    ;

block_
    : LBRACE (rule_ | declaration)* RBRACE
    ;
