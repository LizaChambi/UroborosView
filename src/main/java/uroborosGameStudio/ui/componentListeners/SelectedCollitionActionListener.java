package uroborosGameStudio.ui.componentListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextArea;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class SelectedCollitionActionListener implements MouseListener {

	private JTextArea codeField;
	private JTable tableCollision;
	private MainWindowModel model;
	private JTable tableBehaviors;
	
	public SelectedCollitionActionListener(JTable table, JTextArea textArea, JTable tableCollision, MainWindowModel model) 
	{
		this.codeField = textArea;
		this.tableCollision = tableCollision;
		this.tableBehaviors = table;
		this.model = model;
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		this.tableBehaviors.clearSelection();
		int row = tableCollision.rowAtPoint(e.getPoint());
		model.setFileCollisionSelected(row);
		codeField.setText(model.getCollitionCode(row));
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
