package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTable;
import javax.swing.JTextArea;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class CodeFieldListener implements KeyListener 
{
	private MainWindowModel model;
	private JTable table;
	private JTextArea codeField;

	public CodeFieldListener(MainWindowModel model, JTable table, JTextArea textArea) 
	{
		this.model = model;
		this.table = table;
		this.codeField = textArea;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if (table.getSelectedRow()>=0)
		{
			model.setTextBehaviorFile(codeField.getText());
		}
	}

}
