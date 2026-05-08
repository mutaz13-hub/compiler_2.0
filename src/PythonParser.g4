parser grammar PythonParser;
@header{
package antlrPython;
}
options { tokenVocab = PythonLexer; }

root
    : ((NEWLINE | stmt)+)? EOF
    ;

stmt
    : simple_stmt
    | compound_stmt
    | decorated
    ;

simple_stmt
    : small_stmt (SEMI small_stmt)* SEMI? NEWLINE                                     #simple_stmt_line
    | LBRACE small_stmt (COMMA small_stmt)*? RBRACE (COMMA + NEWLINE + simple_stmt)*?  #simple_stmt_block
    ;

decorated
    : decorator+ compound_stmt
    ;

compound_stmt
    : (IF | ELIF | ELSE) test COLON suite                                 # if_stmt
    | WHILE test COLON suite                                              # while_stmt
    | FOR exprlist IN (COMMA? test)* COLON suite                          # for_stmt
    | TRY COLON suite (except_clause+)                                    # try_stmt
    | WITH with_item (COMMA with_item)* COLON suite                       # with_stmt
    | DEF name LPAREN (name COMMA?)* RPAREN (ARROW test)? COLON  suite    # func_def
    ;

suite
    : simple_stmt
    | INDENT stmt+ DEDENT
    | NEWLINE stmt*
    ;

decorator
    : AT (DOT? name)* (LPAREN (COMMA? test)* RPAREN)? NEWLINE
    ;

with_item
    : test (AS expr)?
    ;

except_clause
    : EXCEPT COLON suite
    ;

exprlist
    : expr (COMMA expr)* COMMA?
    ;

small_stmt
    : test assign_part?                                                      # expr_stmt
    | RETURN (COMMA?test)*                                                   # return_stmt
    | IMPORT name                                                            # import_stmt
    | FROM name IMPORT ( COMMA? name)*                                       # from_stmt
    ;

assign_part
    :COLON test (EQ (COMMA? test)*)?                                       #annotatedAssign
    | EQ LBRACK NEWLINE simple_stmt NEWLINE RBRACK                         #listAssign
    | EQ LBRACE NEWLINE small_stmt(COMMA small_stmt)*NEWLINE RBRACE        #blockAssign
    ;


test
    : comparison
    | NOT test
    | test AND test
    | test OR test
    ;

comparison
    : expr ( (  EQUALS | NOT_EQ_2 | (NOT? IN) | (IS (NOT)?) | EQ ) expr )*
    ;

expr
    : atom trailer*             #atomExpr
    | expr (PLUS | MINUS) expr  #additiveExpr
    ;

atom
    : LPAREN testlist_comp?  RPAREN    #parenAtom
    | LBRACK testlist_comp? RBRACK     #listAtom
    | name                             #nameAtom
    | PRINT                            #printAtom
    | MINUS? number                    #numberAtom
    | NONE                             #noneAtom
    | STRING+                          #stringAtom
    ;

testlist_comp
    : test (FOR test IN (COMMA? test)* (IF test)* | (COMMA test )*)
    ;

name
    : NAME
    | TRUE
    | FALSE
    ;

number
    : DECIMAL_INTEGER
    | FLOAT_NUMBER
    ;

trailer
    : DOT name
    | LPAREN (COMMA? test)* RPAREN
    ;
