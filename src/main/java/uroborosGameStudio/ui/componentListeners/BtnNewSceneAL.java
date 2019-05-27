package uroborosGameStudio.ui.componentListeners;


import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class BtnNewSceneAL extends AbstractEditionListener
{
	private Integer idScene;
	
	public BtnNewSceneAL(JTable table, JTree treeScenes, int idScene, Canvas canvas) 
	{
		super(treeScenes, canvas, table);
		this.idScene = idScene;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
		if(selectedNode.getLevel() == 0)
		{
			UGSProject ugsGame = (UGSProject) gameObject;
			SceneWrapper newScene = new SceneWrapper("Escena" + this.idScene);
			ugsGame.addScene(newScene);
			modelNode.insertNodeInto(new DefaultMutableTreeNode(newScene), selectedNode, modelNode.getChildCount(selectedNode));
			this.idScene++;
		}
	}

	@Override
	public void updateComponents(GameObject gameObject) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
	}
}
