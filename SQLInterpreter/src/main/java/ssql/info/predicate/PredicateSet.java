package ssql.info.predicate;

import dbEngine.document.Document;

import java.util.ArrayList;
import java.util.List;

public abstract class PredicateSet {

    protected PredicateSet left;

    protected PredicateSet right;

    protected List<Predicate> leaves;

    private boolean isNeg = false;

    public List<Predicate> getLeaves() {
        return leaves;
    }

    public PredicateSet getLeft() {
        return left;
    }

    public PredicateSet getRight() {
        return right;
    }

    public void isNeg() {
        isNeg = !isNeg;
    }

    public boolean getNeg() {
        return isNeg;
    }

    public List<Predicate> getAllPredicate() {
        List<Predicate> ret = new ArrayList<>();
        if (left != null) {
            List<Predicate> leftAll = left.getAllPredicate();
            ret.addAll(leftAll);
        }
        if (right != null) {
            List<Predicate> rightAll = right.getAllPredicate();
            ret.addAll(rightAll);
        }
        if (this.leaves != null) ret.addAll(this.leaves);
        return ret;
    }

    public boolean checkContain(Document document) {
        boolean ret = true;
        if (this.leaves != null) {
            for (Predicate p : leaves) {
                ret &= document.judge(p.getLVal(), p.getRVal());
            }
        }
        if (ret && left != null && right != null) {
            boolean l = left.checkContain(document);
            boolean r = right.checkContain(document);
            ret = l | r;
        }
        return ret ^ isNeg;
    }
}
