package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;

public class SlotLabels extends GridPanel implements Observer {
	private List<SlotLabel> labelList;
	private Sheet sheet;

	public SlotLabels(int rows, int cols, Sheet s, CurrentSlot currSlot) {
		super(rows + 1, cols);
		sheet = s;
		sheet.addObserver(this);
		labelList = new ArrayList<SlotLabel>(rows * cols);
		for (char ch = 'A'; ch < ('A' + cols); ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
					SwingConstants.CENTER));
		}
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < ('A' + cols); ch++) {
				SlotLabel label = new SlotLabel("" + ch + row, currSlot);
				add(label);
				labelList.add(label);
			}
		}
		SlotLabel firstLabel = labelList.get(0);
		currSlot.ChangeSlot(firstLabel);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for (SlotLabel l : labelList) {
			l.setText(sheet.valueToString(l.getAddress()));
		}

	}
}
