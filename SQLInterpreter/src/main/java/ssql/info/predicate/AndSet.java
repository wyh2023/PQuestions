package ssql.info.predicate;

import java.util.ArrayList;

public class AndSet extends PredicateSet {

    public AndSet(PredicateSet left, PredicateSet right) {
        leaves = new ArrayList<>();
        leaves.addAll(left.getLeaves());
        leaves.addAll(right.getLeaves());
    }

}
