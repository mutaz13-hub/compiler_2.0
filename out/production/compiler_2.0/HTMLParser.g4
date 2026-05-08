parser grammar HTMLParser;
@header{
package antlrHTML;
}
options {
  tokenVocab=HTMLLexer;
}
root
    :(html_content+)? EOF
    ;

html_content
    :tag
    |style
    |jinja2
    ;

tag
    : TAG_OPEN SLASH? tag_content  SLASH? TAG_CLOSE ID*?COLON?
    ;

tag_content
    :ID ident*
    ;

ident
    :ID
    |EQ
    |DOUBLE_QUOTE_STRING
    ;
///////////style///////
style
    :rule
    |atRule
    ;

rule : selector ID? COMMA?ID?ID?COMMA?ID?ID? LBRACE declaration* RBRACE ;

selector : simpleSelector ( combinator simpleSelector )* ( COMMA selector )? ;

simpleSelector : ( typeSelector | universal ) ( HASH | class | attrib  )* ;

typeSelector : ID?;

universal : STAR ;

class : DOT ID ;

attrib
    : LBRACK ID ( ( EQ | TILDE_EQUALS | PIPE_EQUALS | CARET_EQUALS | DOLLAR_EQUALS | STAR_EQUALS ) ( ID  ) ) RBRACK #attribWithValue
    | LBRACK ID RBRACK #attribWithoutValue
    ;

combinator : TAG_CLOSE #childCombinator
           | PLUS #adjacentSiblingCombinator
           | TILDE #generalSiblingCombinator ;

declaration : property COLON value  SEMI? ;

property : ID #identProperty
         | VAR #varProperty
         ;

value : valuePart+ ;

valuePart : ID #identValue
          | VAR #varValue
          | NUMBER #numberValue
          | HASH #hashValue
          | IMPORTANT #importantValue
          | URL (  ID | NUMBER | SLASH | COLON | DOT | QUESTION | EQ | AND | MINUS | PLUS )* RPAREN #urlValue
          | LPAREN value RPAREN #parenValue
          | COMMA #commaValue
          | DOT #dotValue
          | COLON #colonValue
          | SLASH #slashValue
          | TAG_OPEN #greaterValue
          | PLUS #plusValue
          | MINUS #minusValue
          | STAR #starValue
          | TILDE #tildeValue
          | EQ #equalsValue
          | QUESTION #questionValue
          |DOUBLE_QUOTE_STRING #doubleQuoteValue
          ;

atRule
    : AT_RULE ( valuePart | URL ( ID | NUMBER )? RPAREN )* atRuleBody
    ;

atRuleBody
    : LBRACE ( rule | declaration | atRule )* RBRACE #atRuleWithBlock
    | SEMI #atRuleWithoutBlock
    ;

////////////Jinja2///////
jinja2
    :statement

    ;
statement
    : stmt
    | expr
    ;
stmt
    :BLOCK_START ID*? BLOCK_END
    ;

expr
    :VAR_START expr_content*  VAR_END
    ;
expr_content
    :ID
    |LPAREN
    |RPAREN
    |COLON
    |NUMBER
    |DOUBLE_QUOTE_STRING
    |OR
    |LBRACK
    |RBRACK
    |PIPE
    |TILDE
    |TAG_CLOSE
    ;
