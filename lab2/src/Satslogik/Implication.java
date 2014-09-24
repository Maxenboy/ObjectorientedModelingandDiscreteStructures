package Satslogik;


public class Implication extends Inference {

	public Implication(Expr ex1, Expr ex2) {
		super(ex1, ex2);
	}

	protected boolean valueOfExpr(boolean value1, boolean value2) {
		return !value1 || (value1 && value2);

	}

	@Override
	public String toString() {
		return "(" + ex1.toString() + "-->" + ex2.toString() + ")";
	}

}
