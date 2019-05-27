package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;

public class BtnEditNameAL extends AbstractEditionListener
{
	private JTextField textField;

	public BtnEditNameAL(JTable table, JTree treeScenes, JTextField textField,Canvas canvas) 
	{
		super(treeScenes, canvas, table);
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
