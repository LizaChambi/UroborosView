package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.Game;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class SceneTreePanelTSL implements TreeSelectionListener 
{
	private JTree treeScenes;
	private JTextField textField;
	private Canvas canvas;
	
	public SceneTreePanelTSL(JTree treeScenes, JTextField textField, Canvas canvas) 
	{
		this.treeScenes = treeScenes;
		this.textField = textField;
		this.canvas = canvas;
	}

	public void valueChanged(TreeSelectionEvent e) 
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		
		if(selectedNode.getUserObject().getClass() == UGSProject.class)
		{
			UGSProject ugsGame = (UGSProject) selectedNode.getUserObject();
			
			textField.setText(ugsGame.getGameTitle());
			/* Cada contenido de un if debe invocar a un metodo que diga todo lo que cambia al...
			 * seleccionar ese objeto. Las cuales son:
			 * 
			 *  - Cambiar la vista para el Panel de edición por otro panel ya creado con:
			 *  	scrollEditorPanel.setViewportView(ActorEditorPanel);
			 *  - Cambiar los valores de los bind en diferentes metodos, como:
			 *  	bindName() => txtName.setText(obj.getName());
			 *  	bindDimension() => 	txtDimX.setText(obj.getX());
			 *  						txtDimY.setText(obj.getY());
			 *  	bindImage() => txtImagePath.setText(obj.getPathImage());
			 */
	
		}
		if(selectedNode.getUserObject().getClass() == SceneWrapper.class)
		{
			SceneWrapper sceneWpp = (SceneWrapper) selectedNode.getUserObject();
			textField.setText(sceneWpp.getName());
			setCanvas(sceneWpp);
			Game.setScene(sceneWpp.getName());
		}
		if(selectedNode.getUserObject().getClass() == ActorWrapper.class)
		{
			ActorWrapper actorWpp = (ActorWrapper) selectedNode.getUserObject();
			textField.setText(actorWpp.getName());
			
		}	
	}

	private void setCanvas(SceneWrapper sceneWpp) 
	{
		this.canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for (Integer i=0; i< sceneWpp.cantActors(); i++)
		{
			ActorWrapper actor = sceneWpp.getActorIn(i);
			this.canvas.getGraphics().drawImage(actor.getImage(), actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight(), null);
		}
	}

}
