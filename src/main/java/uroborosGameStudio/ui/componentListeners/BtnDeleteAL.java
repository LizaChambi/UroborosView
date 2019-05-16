package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnDeleteAL extends AbstractEditionListener {

	private JTextField name;
	private MainWindowModel model;
	private SceneWrapper scene;
	private ActorWrapper actor;

	public BtnDeleteAL(JTree treeScenes, Canvas canvas, JTextField nameTextField, MainWindowModel model) {
		super(treeScenes, canvas);
		this.name = nameTextField;
		this.model = model;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		if(selectedNode.getLevel() == 1) {
			System.out.println("voy a eliminar una escena");
			scene = (SceneWrapper) gameObject;
			DefaultTreeModel mdl = (DefaultTreeModel) treeScenes.getModel();
			mdl.removeNodeFromParent(selectedNode);
		}
		
		if(selectedNode.getLevel() == 2) {
			actor = (ActorWrapper) gameObject;
			SceneWrapper currentScene = model.deleteActor(actor);
			
			DefaultTreeModel mdl = (DefaultTreeModel) treeScenes.getModel();
			mdl.removeNodeFromParent(selectedNode);
			setCanvas(currentScene);
		}
	}

	@Override
	public void updateComponents(GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents() {
		treeScenes.updateUI();
	}
	
	/* 	ELIMINAR UN NODO DEL ARBOL DE DIRECCIONES
	 * 
	protected void removeNode(ActionEvent e) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel mdl = (DefaultTreeModel) treeScenes.getModel();
			mdl.removeNodeFromParent(lastNode);
		}
	}
	*/

}
