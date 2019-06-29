package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.geometry.Rotation;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;

public abstract class AbstractEditionListener extends AbstractTableListener implements ActionListener, TreeSelectionListener
{
	public JTree treeScenes;
	public Canvas canvas;
	
	public AbstractEditionListener(JTree treeScenes, Canvas canvas)
	{
		this.treeScenes = treeScenes;
		this.canvas = canvas;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		updateSelectedItem();
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) 
	{
		updateSelectedItem();
	}
	
	public void updateSelectedItem()
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (selectedNode != null)
		{
			GameObject gameObject = (GameObject) selectedNode.getUserObject();
			updeteComponent(selectedNode, gameObject);
			updateComponents(gameObject);
			updateComponents();
		}
	}

	public abstract void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject);

	public abstract void updateComponents(GameObject gameObject);

	public abstract void updateComponents();
	
	public void setCanvas(SceneWrapper sceneWpp) 
	{
		this.canvas.clear();
		this.canvas.show();
		sceneWpp.getActors().forEach(actor -> drawActor(actor));
	}

	public void drawActor(ActorWrapper actor) 
	{
		Game.setScene(Game.getSceneWithActor(actor.getName()));
		Actor actorToDraw = Game.getActorOnCurrentScene(actor.getName());
		this.canvas.getGameGraphics().render(actorToDraw.getTexture(), actorToDraw.getDimension(), actorToDraw.getPosition(), Rotation.NO_ROTATION);
		this.canvas.show();
	}
}
