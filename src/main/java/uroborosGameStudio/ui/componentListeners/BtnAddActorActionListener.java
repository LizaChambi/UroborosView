package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.ui.NewActorDialog;
import uroborosGameStudio.ui.components.ActorsPanel;

public class BtnAddActorActionListener extends AbstractEditionListener 
{
	JTextField name;
	JTextField pathImage;
	JTextField numFrames;
	JTextField width;
	JTextField height;
	NewActorDialog dialog;
	private ActorsPanel actorsPanel;
	
	public BtnAddActorActionListener(JTree treeScenes, Canvas canvas, JTextField textFieldName, JTextField textFieldImagen, JTextField textFieldNumFrames, JTextField textFieldWidth, JTextField textFieldHeight, ActorsPanel actorsPanel, NewActorDialog dialog) 
	{
		super(treeScenes, canvas);
		this.name = textFieldName;
		this.pathImage =textFieldImagen;
		//this.numFrames = textFieldNumFrames;
		this.width = textFieldWidth;
		this.height = textFieldHeight;
		this.dialog = dialog;
		this.actorsPanel = actorsPanel;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
		if(selectedNode.getLevel() == 1)
		{
			SceneWrapper scene = (SceneWrapper) gameObject;
			ActorWrapper newActor = new ActorWrapper(name.getText(), pathImage.getText(), 0, 0, Integer.parseInt(width.getText()), Integer.parseInt(height.getText()));
			scene.addActor(newActor);
			System.out.println("Actor a agregar: " + newActor);
			System.out.println(actorsPanel);
			actorsPanel.addActor(newActor);
			drawActor(newActor);
			modelNode.insertNodeInto( new DefaultMutableTreeNode(newActor), selectedNode, modelNode.getChildCount(selectedNode));
		}
	}

	@Override
	public void updateComponents(GameObject gameObject) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateComponents() {
		dialog.dispose();
	}

}
