package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class SceneTreePanelTSL extends AbstractEditionListener 
{
	private JTextField textField;
	private MainWindowModel model;
	
	public SceneTreePanelTSL(JTree treeScenes, JTextField textField, Canvas canvas, MainWindowModel model) 
	{
		super(treeScenes, canvas);
		this.textField = textField;
		this.model = model;
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
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

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub	
	}

}
