package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.GameObject;

public class BtnEditNameAL extends AbstractEditionListener
{
	private JTextField textField;

	public BtnEditNameAL(JTree treeScenes, JTextField textField,Canvas canvas) 
	{
		super(treeScenes, canvas);
		this.textField = textField;
	}

	@Override
	public void updateComponents() {
		treeScenes.updateUI();
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		gameObject.setName(textField.getText());
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
	}

}
