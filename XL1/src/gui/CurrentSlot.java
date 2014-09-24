package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import model.Sheet;
import util.XLException;

public class CurrentSlot extends Observable implements ActionListener {
	private SlotLabel slotLabel;
	private Sheet sheet;

	public CurrentSlot(Sheet sheet) {
		slotLabel = new SlotLabel(null, null);
		this.sheet = sheet;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sheet.put(slotLabel.getAddress(), e.getActionCommand());
		} catch (XLException q) {
			setChanged();
			notifyObservers(q.getMessage());
		}
	}

	public void ChangeSlot(SlotLabel slot) {
		slotLabel.setBackground(Color.WHITE);
		slotLabel = slot;
		slotLabel.setBackground(Color.YELLOW);
		setChanged();
		notifyObservers();
	}

	public String currentExpression() {
		return sheet.expressionToString(getAddress());
	}

	public String getAddress() {
		return slotLabel.getAddress();
	}
}
