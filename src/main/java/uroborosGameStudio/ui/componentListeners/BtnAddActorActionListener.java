package uroborosGameStudio.ui.componentListeners;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.ui.NewActorDialog;

public class BtnAddActorActionListener extends AbstractEditionListener 
{
	JTextField name;
	JTextField pathImage;
	JTextField numFrames;
	JTextField width;
	JTextField height;
	JCheckBox animationEnable;
	NewActorDialog dialog;
	
	public BtnAddActorActionListener(JTree treeScenes, Canvas canvas, JCheckBox cbxFramesEnable, JTextField textFieldName, JTextField textFieldImagen, JTextField textFieldNumFrames, JTextField textFieldWidth, JTextField textFieldHeight, NewActorDialog dialog) 
	{
		super(treeScenes, canvas);
		this.name = textFieldName;
		this.pathImage =textFieldImagen;
		this.animationEnable = cbxFramesEnable;
		this.numFrames = textFieldNumFrames;
		this.width = textFieldWidth;
		this.height = textFieldHeight;
		this.dialog = dialog;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
		if(selectedNode.getLevel() == 1)
		{
			SceneWrapper scene = (SceneWrapper) gameObject;
			ActorWrapper newActor;
			if(animationEnable.isSelected())
			{
				newActor = new ActorWrapper(name.getText(), pathImage.getText(), 0, 0, Integer.parseInt(width.getText()), Integer.parseInt(height.getText()),Integer.parseInt(numFrames.getText()));
			}
			else
			{
				newActor = new ActorWrapper(name.getText(), pathImage.getText(), 0, 0);
			}
			scene.addActor(newActor);
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
