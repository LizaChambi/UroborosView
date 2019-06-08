package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTable;
import javax.swing.JTextArea;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class CodeFieldListener implements KeyListener 
{
	private MainWindowModel model;
	private JTable tableBehaviors;
	private JTable tableCollisions;
	private JTextArea codeField;

	public CodeFieldListener(MainWindowModel model, JTable table, JTable tableCollision, JTextArea textArea) 
	{
		this.model = model;
		this.tableBehaviors = table;
		this.tableCollisions = tableCollision;
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
		if (tableCollisions.getSelectedRow()>=0)
		{
			model.setTextCollition(codeField.getText());
		}
		else
		{
			model.setTextBehaviorFile(codeField.getText());
		}
	}

}
