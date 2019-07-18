package uroborosGameStudio.ui.componentListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextArea;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class SelectedBehaviorFileActionListener implements MouseListener 
{
	private JTable table;
	private JTextArea codeField;
	private MainWindowModel model;
	private JTable tableCollision;

	public SelectedBehaviorFileActionListener(JTable tableCollision, JTextArea textArea, JTable table, MainWindowModel model) 
	{
		this.codeField = textArea;
		this.table = table;
		this.model = model;
		this.tableCollision = tableCollision;
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		tableCollision.clearSelection();
		int row = table.rowAtPoint(e.getPoint());
		model.setFileSelected(row);
		codeField.setText(model.getBehaviorFile(row));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
