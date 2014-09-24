package model;

import java.util.HashMap;
import java.util.Observable;

import util.XLException;
import expr.Environment;

public class Sheet extends Observable implements Environment {
	private HashMap<String, Slot> slots;
	private Slot nullSlot;

	public Sheet() {
		slots = new HashMap<String, Slot>();
		nullSlot = new NullSlot();
	}

	public void clear(String address) {
		slots.remove(address);
		setChanged();
		notifyObservers();
	}

	public void clearAll() {
		slots.clear();
		setChanged();
		notifyObservers();
	}

	public String expressionToString(String s) {
		return getSlot(s).expressionToString();
	}

	private Slot getSlot(String s) {
		if (slots.containsKey(s)) {
			return slots.get(s);
		}
		return nullSlot;
	}

	public void load(XLBufferedReader reader) {
		clearAll();
		reader.load(this);
	}

	public void put(String string1, String string2) {
		Slot oldtemp = getSlot(string1);
		Slot newtemp = SlotParser.parse(string2);
		if (newtemp instanceof NullSlot) {
			clear(string1);
		} else {
			slots.put(string1, new CircularSlot());
			try {
				newtemp.valueToString(this);
			} catch (XLException e) {
				slots.put(string1, oldtemp);
				throw e;
			}
			slots.put(string1, newtemp);
		}
		try {
			for (Slot t : slots.values()) {
				t.valueToString(this);
			}
		} catch (XLException e) {
			if (!(oldtemp instanceof NullSlot)) {
				slots.put(string1, oldtemp);
			}
			throw e;
		}
		setChanged();
		notifyObservers();
	}

	public void save(XLPrintStream print) {
		print.save(slots.entrySet());

	}

	@Override
	public double value(String s) {
		return getSlot(s).value(this);
	}

	public String valueToString(String s) {
		return getSlot(s).valueToString(this);
	}
}
