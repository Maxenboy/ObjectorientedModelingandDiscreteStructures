package model;

import util.XLException;
import expr.Environment;

public class CircularSlot implements Slot {

	@Override
	public String expressionToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double value(Environment env) throws XLException {
		// TODO Auto-generated method stub
		throw new XLException("Circular dependancy");
	}

	@Override
	public String valueToString(Environment env) {
		return null;

	}

}
