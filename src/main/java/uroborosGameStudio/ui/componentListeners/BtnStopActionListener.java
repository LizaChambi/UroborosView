package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnStopActionListener extends AbstractEditionListener {

	private MainWindowModel model;
	
	public BtnStopActionListener(JTree treeScenes, Canvas canvas, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.model = model;
	}

	
	@Override
	public void updateComponents(GameObject gameObject) 
	{
		model.stopAudio();
		Game.end(); // luego de esta linea se borra el curent scene en UEngine
		this.canvas.clear();
		this.canvas.show();
		model.getProject().loadProject();
	}
	
	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {}


	@Override
	public void updateComponents() {}

}
