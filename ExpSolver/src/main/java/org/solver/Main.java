package org.solver;


public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver(6, 5);
        solver.solve();
        solver.output();
    }

}