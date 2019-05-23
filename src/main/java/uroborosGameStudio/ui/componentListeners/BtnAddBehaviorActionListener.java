package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import uroborosGameStudio.domain.AdmBehaviors;
import uroborosGameStudio.domain.BehaviorFile;
import uroborosGameStudio.ui.NewBehaviorDialog;

public class BtnAddBehaviorActionListener implements ActionListener 
{
	private AdmBehaviors datosDePrueba; 
	private JTable table;
	private JTextField nameTextField;
	private JTextArea textDescription;
	private JCheckBox chbxIsGlobal;
	private NewBehaviorDialog dialog;
	
	public BtnAddBehaviorActionListener(AdmBehaviors datosDePrueba, JTable table, JTextField nameTextField, JTextArea textDescription, JCheckBox chbxIsGlobal, NewBehaviorDialog behaviorDialog) 
	{
		this.datosDePrueba = datosDePrueba;
		this.table = table;
		this.nameTextField= nameTextField;
		this.textDescription = textDescription;
		this.chbxIsGlobal = chbxIsGlobal;
		this.dialog = behaviorDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		BehaviorFile newBehavior = new BehaviorFile(nameTextField.getText(), textDescription.getText(), chbxIsGlobal.isSelected());
		datosDePrueba.addBehavior(newBehavior);
		this.updateTable();
		dialog.dispose();
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
