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

	private JTextField nameField;
	private JTextField posXField;
	private JTextField posYField;
	private JTextField pathImageField;
	private JTextField widthField;
	private JTextField highField;
	private MainWindowModel model;
	private SceneWrapper scene;
	private ActorWrapper actor;

	public BtnDeleteAL(JTree treeScenes, Canvas canvas, JTextField nameTextField, JTextField posXTextField, JTextField posYTextField, JTextField textFieldPathImage, JTextField textFieldWidth, JTextField textFieldHigh, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.nameField = nameTextField;
		this.posXField = posXTextField;
		this.posYField = posYTextField;
		this.pathImageField = textFieldPathImage;
		this.widthField = textFieldWidth;
		this.highField = textFieldHigh;
		this.model = model;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{	
		if(selectedNode.getLevel() == 1) {
			scene = (SceneWrapper) gameObject;
			model.deleteScene(scene);
			
			DefaultTreeModel mdl = (DefaultTreeModel) treeScenes.getModel();
			mdl.removeNodeFromParent(selectedNode);
			setCanvas(scene);
		}
		
		if(selectedNode.getLevel() == 2) {
			actor = (ActorWrapper) gameObject;
			SceneWrapper currentScene = model.deleteActor(actor);
			
			DefaultTreeModel mdl = (DefaultTreeModel) treeScenes.getModel();
			mdl.removeNodeFromParent(selectedNode);
			setCanvas(currentScene);
		}
		cleanProperties();
	}

	@Override
	public void updateComponents(GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents() {
		treeScenes.updateUI();
	}

	private void cleanProperties() 
	{
		this.nameField.setText("");
		this.posXField.setText("0");
		this.posYField.setText("0");
		this.pathImageField.setText("");
		this.widthField.setText("0");
		this.highField.setText("0");
	}

}
