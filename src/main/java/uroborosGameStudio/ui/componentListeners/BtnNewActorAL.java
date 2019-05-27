package uroborosGameStudio.ui.componentListeners;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.NewActorDialog;

public class BtnNewActorAL extends AbstractEditionListener 
{
	private MainWindowModel model;
	
	public BtnNewActorAL(JTable table, JTree treeScenes, Canvas canvas, MainWindowModel model) 
	{
		super(treeScenes, canvas, table);
		this.model = model;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		if(selectedNode.getLevel() == 1)
		{
			NewActorDialog dialog = new NewActorDialog(getTable(), model, treeScenes, canvas);
			dialog.setLocationRelativeTo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
	
	@Override
	public void updateComponents(GameObject gameObject) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void updateComponents() 
	{
		// TODO Auto-generated method stub
	}
}
