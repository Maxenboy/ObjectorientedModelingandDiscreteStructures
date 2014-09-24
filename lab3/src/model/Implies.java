package model;

import java.util.Set;
import predicate.Expr;
import term.Term;
import term.Variable;

public class Implies implements Expr {
	Expr expr1;
	Expr expr2;

	public Implies(Expr px, Expr py) {
		this.expr1 = px;
		this.expr2 = py;
	}

	public Expr substitute(Variable variable, Term term) {
		return new Implies(expr1.substitute(variable, term), expr2.substitute(
				variable, term));
	}

	@Override
	public String toString() {
		return expr1.toString() + " -> " + expr2.toString();
	}

	@Override
	public Set<Variable> variables(Set<Variable> set) {
		expr1.variables(set);
		expr2.variables(set);
		return set;
	}

}
