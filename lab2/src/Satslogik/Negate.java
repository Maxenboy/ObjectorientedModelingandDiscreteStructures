package Satslogik;

import java.util.Map;
import java.util.Set;

public class Negate extends Expr {
	private Expr ex;

	public Negate(Expr ex) {
		this.ex = ex;

	}

	protected void collectVariables(Set<Variable> set) {
		ex.collectVariables(set);

	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return !ex.value(map);
	}

	@Override
	public String toString() {
		return "(" + ex.toString() + ")" + "'";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ex == null) ? 0 : ex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negate other = (Negate) obj;
		if (ex == null) {
			if (other.ex != null)
				return false;
		} else if (!ex.equals(other.ex))
			return false;
		return true;
	}

}
