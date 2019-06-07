package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnRemoveColliderActionListener extends AbstractTableListener implements ActionListener
{
	private JTable tableCollision;
	private JPanel principalPanel;
	private MainWindowModel model;
	private JTextArea textArea;
	
	public BtnRemoveColliderActionListener(JTextArea textArea, MainWindowModel model, JTable table, JTable tableCollision, JPanel principalPanel) 
	{
		super(table);
		this.tableCollision = tableCollision;
		this.principalPanel=principalPanel;
		this.model = model;
		this.textArea = textArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int fileSelected = tableCollision.getSelectedRow();
		if(fileSelected >= 0)
		{
			model.getItemSelected().removeCollisionIndex(fileSelected);
		}
		else
		{
			JOptionPane.showMessageDialog(principalPanel,"No se ha seleccionado ninguna colisión para eliminar.", "No se puedo eliminar", JOptionPane.INFORMATION_MESSAGE);
		}
		this.updateTableCollider(tableCollision, model.getItemSelected());
		textArea.setText("");
	}

}
