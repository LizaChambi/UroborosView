package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.ui.NewActorDialog;

public class BtnNewActorAL extends AbstractEditionListener 
{
	private JComboBox<ActorWrapper> comboBox;
	
	public BtnNewActorAL(JTree treeScenes, JComboBox<ActorWrapper> comboBox, Canvas canvas) 
	{
		super(treeScenes, canvas);
		this.comboBox = comboBox;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
		if(selectedNode.getLevel() == 1)
		{
			SceneWrapper scene = (SceneWrapper) gameObject;
			
			
			NewActorDialog dialog = new NewActorDialog();
			dialog.setLocationRelativeTo(null);// Hace que la ventana se abra en el centro de la pantalla
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
			ActorWrapper newActor = (ActorWrapper) comboBox.getSelectedItem();
			scene.addActor(newActor);
			drawActor(newActor);
			modelNode.insertNodeInto( new DefaultMutableTreeNode(newActor), selectedNode, modelNode.getChildCount(selectedNode));
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
