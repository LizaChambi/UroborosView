package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uroborosGameStudio.domain.AdmBehaviors;

public class AbstractTableListener 
{
	private AdmBehaviors datosDePrueba; 
	private JTable table;
	
	public AbstractTableListener(AdmBehaviors datosDePrueba, JTable table)
	{
		this.datosDePrueba = datosDePrueba;
		this.table = table;
	}
	
	public AdmBehaviors getModel()
	{
		return datosDePrueba;
	}
	
	public JTable getTable()
	{
		return this.table;
	}
	
	protected void updateTable() 
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
