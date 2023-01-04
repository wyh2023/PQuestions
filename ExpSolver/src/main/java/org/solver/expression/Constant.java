package org.solver.expression;

public class Constant extends Expression {

    private final int val;

    public Constant(int val) {
        this.val = val;
    }

    @Override
    public int len() {
        return 1;
    }

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
