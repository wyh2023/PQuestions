package org.solver;

import org.solver.expression.AddExp;
import org.solver.expression.Constant;
import org.solver.expression.Expression;
import org.solver.expression.MulExp;
import org.solver.expression.SymbolTable;
import org.solver.expression.Variable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solver {

    private final int len;
    private final int eval;
    private final List<Expression> symbols;

    private final List<Set<Expression>> exps;
    SymbolTable table = new SymbolTable();

    public Solver(int L, int N) {
        this.len = L;
        this.eval = N;
        this.exps = new ArrayList<>();
        this.symbols = new ArrayList<>();
    }

    private void initialize() {
        Variable x = new Variable("x");
        symbols.add(x);
        table.putPair(x, 3);
        Variable y = new Variable("y");
        symbols.add(y);
        table.putPair(y, 5);
        symbols.add(new Constant(1));
        symbols.add(new Constant(2));
        for (int i = 0; i < len; i++)
            exps.add(new HashSet<>());
    }

    // Backtrack
    public void solve() {
        initialize();
        for (Expression exp : symbols) {
            exps.get(1).add(exp);
        }
        for (int cur = 2; cur < len; cur++) {
            for (int left = 1; left < cur - 1; left++) {
                int right = cur - left - 1;
                for (Expression lExp : exps.get(left)) {
                    for (Expression rExp : exps.get(right)) {
                        exps.get(cur).add(new AddExp(lExp, rExp));
                        exps.get(cur).add(new MulExp(lExp, rExp));
                    }
                }
            }
        }
    }

    public void output() {
        for (int i = 0; i < len; i++) {
            exps.get(i).stream()
                    .filter(exp -> exp.getVal() == eval)
                    .forEach(System.out::println);
        }
    }

}
