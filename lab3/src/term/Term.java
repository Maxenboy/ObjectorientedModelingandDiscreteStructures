package term;

import java.util.Set;

public interface Term {
	public Set<Variable> collectVariables(Set<Variable> set);

	public Term substitute(Variable x, Term term);

	public boolean equals(Object object);
}
