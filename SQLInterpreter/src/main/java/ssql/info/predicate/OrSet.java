package ssql.info.predicate;

public class OrSet extends PredicateSet{

    public OrSet(PredicateSet left, PredicateSet right) {
        this.left = left;
        this.right = right;
    }

}
