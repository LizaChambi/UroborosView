package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnEditImageActionListener extends AbstractEditionListener {

	private JTextField pathImageField;
	private MainWindowModel model;
	
	public BtnEditImageActionListener(JTree treeScenes, Canvas canvas, JTextField textFieldPathImage, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.pathImageField = textFieldPathImage;
		this.model = model;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		gameObject.setPathImage(pathImageField.getText());
		SceneWrapper selectedScene = gameObject.selectedScene(model);
		if (selectedScene != null)
		{
			setCanvas(selectedScene);
		}
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}


}
