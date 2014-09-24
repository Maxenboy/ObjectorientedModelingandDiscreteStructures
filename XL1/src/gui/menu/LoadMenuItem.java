package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;

import model.Sheet;
import model.XLBufferedReader;

class LoadMenuItem extends OpenMenuItem {

	public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
		super(xl, statusLabel, "Load", sheet);
	}

	protected void action(String path) throws FileNotFoundException {
		try {
			XLBufferedReader xbr = new XLBufferedReader(path);
			sheet.load(xbr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected int openDialog(JFileChooser fileChooser) {
		return fileChooser.showOpenDialog(xl);
	}
}