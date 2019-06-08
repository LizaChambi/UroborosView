package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTree;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.NewBehaviorDialog;

public class BtnNewBehaviorActionListener implements ActionListener 
{
	private JTable table;
	private JTree treeScenes;
	private Canvas canvas;
	private MainWindowModel model;
	
	public BtnNewBehaviorActionListener(MainWindowModel model, JTree treeScenes, Canvas canvas, JTable table) 
	{
		this.model = model;
		this.treeScenes = treeScenes;
		this.canvas=canvas;
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		NewBehaviorDialog dialog = new NewBehaviorDialog(model,treeScenes, canvas, table);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);	
	}
}
