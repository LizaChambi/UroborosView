package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnEditDimensionAL extends AbstractEditionListener
{
	private JTextField posX;
	private JTextField posY;
	private MainWindowModel model;
	
	public BtnEditDimensionAL(JTree treeScenes, JTextField posX, JTextField posY, Canvas canvas, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.posX = posX;
		this.posY = posY;
		this.model = model;
	}
	
	@Override
	public void updateComponents(GameObject gameObject) 
	{
		gameObject.setPosition(Integer.parseInt(posX.getText()), Integer.parseInt(posY.getText()));
		//Actualizar canvas: Notar que el gameObject siempre sera un actor y no puede venir null
		SceneWrapper selectedScene = gameObject.selectedScene(model);
		if (selectedScene != null)
		{
			setCanvas(selectedScene);
		}
	}
	
	
	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub	
	}

}
