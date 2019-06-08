package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnEditDimensionImageActionListener extends AbstractEditionListener
{
	private JTextField widthField;
	private JTextField heightField;
	private MainWindowModel model;
	
	public BtnEditDimensionImageActionListener(JTree treeScenes, Canvas canvas, JTextField textFieldWidth, JTextField textFieldHigh, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.widthField = textFieldWidth;
		this.heightField = textFieldHigh;
		this.model = model;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		gameObject.setDimensionImage(Integer.valueOf(widthField.getText()), Integer.valueOf(heightField.getText()));
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
