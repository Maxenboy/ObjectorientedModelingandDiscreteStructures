package gui.menu;

import gui.CurrentSlot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private Sheet sheet;
	private CurrentSlot currSlot;

	public ClearMenuItem(Sheet sheet, CurrentSlot currSlot) {
		super("Clear");
		this.sheet = sheet;
		addActionListener(this);
		this.currSlot = currSlot;
	}

	public void actionPerformed(ActionEvent e) {
		sheet.clear(currSlot.getAddress());
	}

}