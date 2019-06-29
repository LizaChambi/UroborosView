package uroborosGameStudio.ui.componentListeners;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnStopActionListener extends AbstractEditionListener {

	private MainWindowModel model;
	private JButton btnPlay;
	private JButton btnStop;
	
	public BtnStopActionListener(JTree treeScenes, Canvas canvas, MainWindowModel model, JButton btnPlay, JButton btnStop) 
	{
		super(treeScenes, canvas);
		this.model = model;
		this.btnPlay = btnPlay;
		this.btnStop = btnStop;
	}
	
	@Override
	public void updateComponents(GameObject gameObject) 
	{
		model.stopAudio();
		Game.end();
		model.getProject().loadProject();
		updateUI(gameObject);
	}

	private void updateUI(GameObject gameObject) {
		btnStop.setEnabled(false);
		btnPlay.setEnabled(true);
		setCanvas(gameObject.selectedScene(model));
	}
	
	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {}

	@Override
	public void updateComponents() {
	}

}
