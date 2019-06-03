package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uroborosGameStudio.domain.GameObject;

public abstract class AbstractTableListener 
{
	private JTable table;
	
	public AbstractTableListener(JTable table)
	{
		this.table = table;
	}
	
	public JTable getTable()
	{
		return this.table;
	}
	
	protected void updateTable(GameObject actor) 
	{
		Object newTable[][] = new Object [actor.getBehaviors().size()][4];
	
		for(int col = 0; col <actor.getBehaviors().size(); col++)
		{
			newTable[col][0] = actor.getBehaviors().get(col).getName();
			newTable[col][1] = actor.getBehaviors().get(col).getDescription();
			newTable[col][2] = actor.getBehaviors().get(col).getIsGlobal();
			newTable[col][3] = actor.getBehaviors().get(col).getType().toString();
		}
		table.setModel(new DefaultTableModel(newTable, new Object[] {"Nombre", "Descripción", "Global", "Tipo"}));
	}

}
