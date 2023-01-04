grammar SQL;

SELECT: 'select';
FROM: 'from';
WHERE: 'where';
AND: 'and';
OR: 'or';
NOT: 'not';
TRUE: 'true';
FALSE: 'false';

WS
    : [ \r\n\t]+ -> skip
    ;

INTEGER
    : [0-9]+
    ;

IDENTIFIER
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

STRING
    : '"'[a-zA-Z_0-9]*'"'
    ;

query
    : SELECT columnList FROM table WHERE where EOF
    ;

columnList
    : IDENTIFIER
    | columnList ',' columnList
    ;

where
    : predicate
    | andPredicate
    | orPredicate
    | negPredicate
    ;

andPredicate
    : predicate AND predicate
    ;

orPredicate
    : predicate OR predicate
    ;

negPredicate
    : NOT predicate
    ;

predicate
    : IDENTIFIER '=' IDENTIFIER
    | IDENTIFIER '=' value
    ;

andPred
    :
    ;

table
    : IDENTIFIER
    ;

value
    : STRING
    | INTEGER
    | booleanValue
    ;

booleanValue
    : TRUE
    | FALSE
    ;