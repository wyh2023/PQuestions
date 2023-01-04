package org.solver.expression;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private static final Map<Variable, Integer> table = new HashMap<>();

    public void putPair(Variable var, Integer val) {
        table.put(var, val);
    }

    public static int eval(Variable var) {
        if (table.containsKey(var))
            return table.get(var);
        else
            throw new RuntimeException("Undefined Variable");
    }

}
