package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uroborosGameStudio.domain.AdmBehaviors;
import uroborosGameStudio.domain.BehaviorFile;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnNewBehaviorActionListener implements ActionListener 
{
	private JTable table;
	private MainWindowModel model;
	
	private AdmBehaviors datosDePrueba;
	
	public BtnNewBehaviorActionListener(JTable table, MainWindowModel model, AdmBehaviors datosDePrueba) 
	{
		this.table = table;
		this.model = model;
		this.datosDePrueba = datosDePrueba;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		BehaviorFile newBF = new BehaviorFile("Nombre", "Nuevo comportamiento agregado.", true);
		datosDePrueba.addBehavior(newBF);
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
		table.setModel(new DefaultTableModel(newTable, new Object[] {"Nombre", "Descripci\\u00F3n", "Global"}));
	}

}
