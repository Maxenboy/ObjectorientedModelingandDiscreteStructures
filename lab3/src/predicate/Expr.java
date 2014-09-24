package predicate;

import java.util.Set;

import term.Term;
import term.Variable;

public interface Expr {
    public Expr substitute(Variable variable, Term term);
    public Set<Variable> variables(Set<Variable> set);
}
