package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {
	CurrentSlot currSlot;

	public CurrentLabel(CurrentSlot currSlot) {
		super("A3", Color.WHITE);
		this.currSlot = currSlot;
		currSlot.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		setText(currSlot.getAddress());

	}
}