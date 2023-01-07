package ssql.info.predicate;

import java.util.ArrayList;

public class EqSet extends PredicateSet{

    public EqSet(Predicate predicate) {
        leaves = new ArrayList<>();
        leaves.add(predicate);
    }

}
