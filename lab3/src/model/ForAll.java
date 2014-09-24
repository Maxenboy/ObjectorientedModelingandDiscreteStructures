package model;

import java.util.HashSet;
import java.util.Set;
import predicate.Expr;
import term.Term;
import term.Variable;

public class ForAll implements Expr {
	Variable x;
	Expr expr;

	public ForAll(Variable x, Expr expr) {
		this.x = x;
		this.expr = expr;
	}

	public Expr substitute(Variable variable, Term term) {
		Set<Variable> set = new HashSet<Variable>();
		if (!variable.equals(x) && !term.collectVariables(set).contains(x)) {
			return new ForAll(x, expr.substitute(variable, term));
		} else if (!variable.equals(x)&& term.collectVariables(set).contains(x)) {
			Variable newvariable = new Variable();
			return new ForAll(newvariable, expr.substitute(x, newvariable).substitute(variable, term));
		}
		return this;

	}

	@Override
	public String toString() {
		return x.toString() + " " + expr.toString();
	}

	@Override
	public Set<Variable> variables(Set<Variable> set) {
		expr.variables(set);
		x.collectVariables(set);
		return set;
	}

}
