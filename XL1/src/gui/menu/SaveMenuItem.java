package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

import model.Sheet;
import model.XLPrintStream;

class SaveMenuItem extends OpenMenuItem {
	public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
		super(xl, statusLabel, "Save", sheet);
	}

	protected void action(String path) throws FileNotFoundException {
		try {
			XLPrintStream xps = new XLPrintStream(path);
			sheet.save(xps);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showSaveDialog(xl);
	}
}