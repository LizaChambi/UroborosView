package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.components.ActorsPanel;

public class SceneTreePanelTSL extends AbstractEditionListener 
{
	private JTextField textField;
	private JTextField posXField;
	private JTextField posYField;
	private ActorsPanel actorsPanel;
	private MainWindowModel model;
	
	public SceneTreePanelTSL(JTree treeScenes, JTextField textField, Canvas canvas, MainWindowModel model, JTextField posXTextField, JTextField posYTextField, ActorsPanel actorsPanel) 
	{
		super(treeScenes, canvas);
		this.textField = textField;
		this.posXField = posXTextField;
		this.posYField = posYTextField;
		this.actorsPanel=actorsPanel;
		this.model = model;
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		textField.setText(gameObject.getName());
		posXField.setText(gameObject.getX().toString());
		posYField.setText(gameObject.getY().toString());
		gameObject.setSceneUEngine();
		SceneWrapper selectedScene = gameObject.selectedScene(model);
		if (selectedScene != null)
		{
			actorsPanel.setActors(selectedScene.getActors());
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

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub	
	}

}
