package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.NewActorDialog;

public class BtnNewActorAL extends AbstractEditionListener 
{
	private MainWindowModel model;
	
	public BtnNewActorAL(JTree treeScenes, Canvas canvas, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.model = model;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		if(selectedNode.getLevel() == 1)
		{
			NewActorDialog dialog = new NewActorDialog(model, treeScenes, canvas);
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
