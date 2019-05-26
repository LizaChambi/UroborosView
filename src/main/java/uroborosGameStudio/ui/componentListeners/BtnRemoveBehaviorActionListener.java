package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uroborosGameStudio.domain.AdmBehaviors;

public class BtnRemoveBehaviorActionListener implements ActionListener 
{

	private JTable table;
	private AdmBehaviors datosDePrueba;
	private JPanel mainPanel;

	public BtnRemoveBehaviorActionListener(JTable table, AdmBehaviors datosDePrueba, JPanel principalPanel) 
	{
		this.table = table;
		this.datosDePrueba = datosDePrueba;
		this.mainPanel = principalPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int fileSelected = table.getSelectedRow();
		if(fileSelected >= 0)
		{
			datosDePrueba.removeBehaviorIndex(fileSelected);
		}
		else
		{
			JOptionPane.showMessageDialog(mainPanel, "No se ah seleccionado ningún comportamiento para eliminar.");
		}
		updateTable();
	}
	
	private void updateTable() 
	{
		Object newTable[][] = new Object [datosDePrueba.getBehaviors().size()][3];
		
		for(int col = 0; col <datosDePrueba.getBehaviors().size(); col++)
		{
			newTable[col][0] = datosDePrueba.getBehaviors().get(col).getName();
			newTable[col][1] = datosDePrueba.getBehaviors().get(col).getDescription();
			newTable[col][2] = datosDePrueba.getBehaviors().get(col).getIsGlobal();
		}
		table.setModel(new DefaultTableModel(newTable, new Object[] {"Nombre", "Descripción", "Global"}));
	}

}
