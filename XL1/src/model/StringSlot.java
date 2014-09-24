package model;

import expr.Environment;

public class StringSlot implements Slot {
	private String contents;

	public StringSlot(String s) {
		contents = s;
	}

	@Override
	public String expressionToString() {
		return "#" + contents;
	}

	@Override
	public double value(Environment env) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String valueToString(Environment env) {
		return contents;
	}

}
