package model;

import java.util.Set;
import predicate.Expr;
import term.Term;
import term.TermList;
import term.Variable;

public class Predicate implements Expr {
	String string;
	TermList xList;

	public Predicate(String string, TermList xList) {
		this.string = string;
		this.xList = xList;
	}

	@Override
	public String toString() {
		return string + xList.toString();
	}

	@Override
	public Expr substitute(Variable variable, Term term) {
		return new Predicate(string, xList.substitute(variable,
				term));
	}

	@Override
	public Set<Variable> variables(Set<Variable> set) {
		return xList.collectVariables(set);
	}
}
