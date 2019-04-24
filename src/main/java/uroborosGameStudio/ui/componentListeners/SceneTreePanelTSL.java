package uroborosGameStudio.ui.componentListeners;

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
	
	public SceneTreePanelTSL(JTree treeScenes, JTextField textField) 
	{
		this.treeScenes = treeScenes;
		this.textField = textField;
		// TODO Auto-generated constructor stub
	}

	public void valueChanged(TreeSelectionEvent e) 
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		
		if(selectedNode.getUserObject().getClass() == UGSProject.class)
		{
			UGSProject obj = (UGSProject) selectedNode.getUserObject();
			
			textField.setText(obj.getGameTitle());
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
			SceneWrapper obj = (SceneWrapper) selectedNode.getUserObject();
			textField.setText(obj.getName());
			Game.setScene(obj.getName());
		}
		if(selectedNode.getUserObject().getClass() == ActorWrapper.class)
		{
			ActorWrapper obj = (ActorWrapper) selectedNode.getUserObject();
			textField.setText(obj.getName());
		}	
		
	}

}
