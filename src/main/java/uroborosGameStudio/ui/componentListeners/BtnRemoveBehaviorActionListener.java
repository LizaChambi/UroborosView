package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import uroborosGameStudio.domain.AdmBehaviors;

public class BtnRemoveBehaviorActionListener extends AbstractTableListener implements ActionListener 
{
	private JPanel mainPanel;

	public BtnRemoveBehaviorActionListener(JTable table, AdmBehaviors datosDePrueba, JPanel principalPanel) 
	{
		super(datosDePrueba, table);
		this.mainPanel = principalPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int fileSelected = getTable().getSelectedRow();
		if(fileSelected >= 0)
		{
			getModel().removeBehaviorIndex(fileSelected);
		}
		else
		{
			JOptionPane.showMessageDialog(mainPanel, "No se ah seleccionado ningún comportamiento para eliminar.");
		}
		updateTable();
	}
}
