package Satslogik;


public class Conjunction extends Inference {

	public Conjunction(Expr ex1, Expr ex2) {
		super(ex1, ex2);
	}

	@Override
	protected boolean valueOfExpr(boolean value1, boolean value2) {
		return value1 && value2;
	}

	@Override
	public String toString() {
		return "(" + ex1.toString() + "&" + ex2.toString() + ")";
	}

}
