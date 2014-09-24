package Satslogik;

import java.util.Map;
import java.util.Set;

public abstract class Inference extends Expr {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ex1 == null) ? 0 : ex1.hashCode());
		result = prime * result + ((ex2 == null) ? 0 : ex2.hashCode());
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
		Inference other = (Inference) obj;
		if (ex1 == null) {
			if (other.ex1 != null)
				return false;
		} else if (!ex1.equals(other.ex1))
			return false;
		if (ex2 == null) {
			if (other.ex2 != null)
				return false;
		} else if (!ex2.equals(other.ex2))
			return false;
		return true;
	}

	protected Expr ex1, ex2;

	public Inference(Expr ex1, Expr ex2) {
		this.ex1 = ex1;
		this.ex2 = ex2;
	}

	@Override
	protected void collectVariables(Set<Variable> set) {
		ex1.collectVariables(set);
		ex2.collectVariables(set);

	}

	protected abstract boolean valueOfExpr(boolean value1, boolean value2);

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean value(Map<Variable, Boolean> map) {
		return valueOfExpr(ex1.value(map), ex2.value(map));
	}

}
