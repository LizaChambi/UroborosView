package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.Collider;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.ui.NewColliderDialog;

public class AddCollisionActionListener extends AbstractEditionListener 
{
	private JTable tableCollision;
	private JTextField nameTextField;
	private JTextArea textDescription;
	private NewColliderDialog dialog;
	
	public AddCollisionActionListener(JTextField nameTextField, JTextArea textDescription, JTree treeScenes, Canvas canvas, JTable table, JTable tableCollision, NewColliderDialog newColliderDialog) 
	{
		super(treeScenes, canvas, table);
		this.tableCollision = tableCollision;
		this.nameTextField = nameTextField;
		this.textDescription = textDescription;
		this.dialog = newColliderDialog;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		Collider collition = new Collider(nameTextField.getText(), textDescription.getText());
		gameObject.addCollision(collition);
		this.updateTableCollider(tableCollision, gameObject);
		dialog.dispose();
	}

	@Override
	public void updateComponents() {
	}

}
