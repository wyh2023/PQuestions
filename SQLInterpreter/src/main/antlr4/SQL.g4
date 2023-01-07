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
    : SELECT columnList FROM table WHERE predicate EOF
    ;

columnList
    : IDENTIFIER
    | columnList ',' columnList
    ;

predicate
    : IDENTIFIER '=' IDENTIFIER
    | IDENTIFIER '=' value
    | predicate AND predicate
    | predicate OR predicate
    | NOT predicate
    | '(' predicate ')'
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