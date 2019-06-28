package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
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
		Game.end();
		model.stopAudio();
		System.out.println("DETUVE EL AUDIO CON EXITO");
		model.getProject().loadProject();
		//System.out.println("NOMBRE DE LA ESCENA A SETEAR" + model.getSceneIn(0).getName());
		//Game.setScene(model.getSceneIn(0).getName());
		//setCanvas(model.getSceneIn(0));
	}
	
	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {}


	@Override
	public void updateComponents() {}

}
