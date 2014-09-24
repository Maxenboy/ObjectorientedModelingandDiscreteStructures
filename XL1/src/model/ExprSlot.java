package model;

import expr.Environment;
import expr.Expr;

public class ExprSlot implements Slot {
	private Expr contents;

	public ExprSlot(Expr expr) {
		contents = expr;
	}

	@Override
	public String expressionToString() {
		return contents.toString();
	}

	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return contents.value(env);
	}

	@Override
	public String valueToString(Environment env) {
		return String.valueOf(value(env));
	}

}
