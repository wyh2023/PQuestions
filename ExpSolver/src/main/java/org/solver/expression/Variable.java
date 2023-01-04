package org.solver.expression;

public class Variable extends Expression {

    private final String symbol;

    public Variable(String var) {
        this.symbol = var;
    }

    @Override
    public int len() {
        return 1;
    }

    @Override
    public int getVal() {
        return SymbolTable.eval(this);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
