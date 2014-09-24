package model;

import expr.Environment;

public interface Slot {

	public String expressionToString();

	public double value(Environment env);

	public String valueToString(Environment env);

}
