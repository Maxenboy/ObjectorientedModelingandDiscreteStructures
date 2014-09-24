package model;

import util.XLException;
import expr.Environment;

public class NullSlot implements Slot {

	@Override
	public String expressionToString() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public double value(Environment env) throws XLException {
		// TODO Auto-generated method stub
		throw new XLException("Empty slot reference");
	}

	@Override
	public String valueToString(Environment env) {
		// TODO Auto-generated method stub
		return "";
	}

}
