package model;

import java.io.IOException;

import util.XLException;
import expr.ExprParser;

public class SlotParser {
	public static Slot parse(String s) {
		Slot t = null;
		if (s.length() == 0) {
			t = new NullSlot();
		} else if (s.charAt(0) == '#') {
			t = new StringSlot(s.substring(1));
		} else {
			try {
				t = new ExprSlot(new ExprParser().build(s));
			} catch (IOException e) {
				e.printStackTrace();
				throw new XLException(e.getMessage());
			}
		}
		return t;

	}
}
