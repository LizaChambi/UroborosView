package uroborosGameStudio.ui.componentListeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.geometry.Rotation;
import org.team.uroboros.uroboros.engine.ui.Canvas;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;

public abstract class AbstractEditionListener implements ActionListener, TreeSelectionListener
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
		sceneWpp.getActors().forEach(act -> drawActor(act));
	}

	public void drawActor(ActorWrapper actor) 
	{
		String spritesheetRoute = actor.getPath();
		SpriteSheet spritesheet = new SpriteSheet(spritesheetRoute, new Frame(Point.ORIGIN, new Dimension(actor.getRealWidth(), actor.getRealHeight())));
		Sprite sprite = new Sprite(spritesheet, 0, new Dimension(actor.getWidth(), actor.getHeight()));
		
		this.canvas.getGraphics().render(sprite, new Point(actor.getX(), actor.getY()), Rotation.NO_ROTATION);
		this.canvas.show();
		// this.canvas.getGraphics().drawImage(actor.getImage(), actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight(), null);
	}

}
