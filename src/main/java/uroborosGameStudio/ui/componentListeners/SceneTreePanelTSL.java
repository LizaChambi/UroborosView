package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class SceneTreePanelTSL implements TreeSelectionListener 
{
	private JTree treeScenes;
	private JTextField textField;
	private Canvas canvas;
	private MainWindowModel model;
	
	public SceneTreePanelTSL(JTree treeScenes, JTextField textField, Canvas canvas, MainWindowModel model) 
	{
		this.treeScenes = treeScenes;
		this.textField = textField;
		this.canvas = canvas;
		this.model = model;
	}

	public void valueChanged(TreeSelectionEvent e) 
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		GameObject gameObject = (GameObject) selectedNode.getUserObject();
		textField.setText(gameObject.getName());
		gameObject.setSceneUEngine();
		SceneWrapper selectedScene = gameObject.selectedScene(model);
		if (selectedScene != null)
		{
			setCanvas(selectedScene);
		}

		/* 
		 * Cada tipo de GameObject debe cambiar el panel de edición:
		 * 
		 * IDEA): Cambiar el panel de edición por un panel propio para Actores/Scenas/Proyecto:
		 * 		scrollPanelEdicion.setViewportView(panelDeEdicionDeScenes);
		 * 		scrollPanelEdicion.setViewportView(panelDeEdicionDeActores);
		 * 		scrollPanelEdicion.setViewportView(panelDeEdicionDelProyecto);
		 */
	}

	private void setCanvas(SceneWrapper sceneWpp) 
	{
		this.canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		sceneWpp.getActors().forEach(act -> drawActor(act));
	}

	private void drawActor(ActorWrapper actor) 
	{
		this.canvas.getGraphics().drawImage(actor.getImage(), actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight(), null);
	}

}
