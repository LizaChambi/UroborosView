package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.NewActorDialog;
import uroborosGameStudio.ui.NewColliderDialog;

public class NewCollisionActionListener implements ActionListener 
{

	private MainWindowModel model;
	private JTable tableCollision;
	private JTree treeScenes;
	private Canvas canvas;
	private JTable tableBehaviors;
	
	public NewCollisionActionListener(MainWindowModel model, JTree treeScenes, Canvas canvas, JTable table, JTable tableCollision) 
	{
		this.treeScenes = treeScenes;
		this.canvas = canvas;
		this.tableBehaviors = table;
		this.model = model;
		this.tableCollision = tableCollision;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		NewColliderDialog dialog = new NewColliderDialog(model, treeScenes, canvas, tableBehaviors, tableCollision);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
