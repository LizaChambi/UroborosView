package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;

import uroborosGameStudio.domain.AdmBehaviors;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.NewBehaviorDialog;

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
		NewBehaviorDialog dialog = new NewBehaviorDialog(datosDePrueba, table);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);	
	}
}
