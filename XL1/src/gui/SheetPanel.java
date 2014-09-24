package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;

public class SheetPanel extends BorderPanel {
	public SheetPanel(int rows, int columns, Sheet s, CurrentSlot currSlot) {
		add(WEST, new RowLabels(rows));
		add(CENTER, new SlotLabels(rows, columns, s, currSlot));
	}
}