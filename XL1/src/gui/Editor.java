package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {
	CurrentSlot currSlot;

	public Editor(CurrentSlot currSlot) {
		this.currSlot = currSlot;
		addActionListener(currSlot);
		currSlot.addObserver(this);
		setBackground(Color.WHITE);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setText(currSlot.currentExpression());

	}
}