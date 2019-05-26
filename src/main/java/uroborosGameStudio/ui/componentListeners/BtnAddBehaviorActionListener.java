package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import uroborosGameStudio.domain.AdmBehaviors;
import uroborosGameStudio.domain.BehaviorFile;
import uroborosGameStudio.ui.NewBehaviorDialog;

public class BtnAddBehaviorActionListener extends AbstractTableListener implements ActionListener
{
	private JTextField nameTextField;
	private JTextArea textDescription;
	private JCheckBox chbxIsGlobal;
	private NewBehaviorDialog dialog;
	
	public BtnAddBehaviorActionListener(AdmBehaviors datosDePrueba, JTable table, JTextField nameTextField, JTextArea textDescription, JCheckBox chbxIsGlobal, NewBehaviorDialog behaviorDialog) 
	{
		super(datosDePrueba, table);
		this.nameTextField= nameTextField;
		this.textDescription = textDescription;
		this.chbxIsGlobal = chbxIsGlobal;
		this.dialog = behaviorDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		BehaviorFile newBehavior = new BehaviorFile(nameTextField.getText(), textDescription.getText(), chbxIsGlobal.isSelected());
		getModel().addBehavior(newBehavior);
		this.updateTable();
		dialog.dispose();
	}
}
