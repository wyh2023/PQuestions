package ssql.info.predicate;

public class Predicate {

    private final String lVal;

    private final String rVal;

    private final boolean eq;

    public Predicate(String l, String r, boolean eq) {
        this.lVal = l;
        this.rVal = r;
        this.eq = eq;
    }

    public String getLVal() {
        return lVal;
    }

    public String getRVal() {
        return rVal;
    }

    public boolean isEq() {
        return eq;
    }
}
