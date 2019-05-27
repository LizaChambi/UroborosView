package uroborosGameStudio.ui.componentListeners;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.BehaviorFile;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.ui.NewBehaviorDialog;

public class BtnAddBehaviorActionListener extends AbstractEditionListener
{
	private JTextField nameTextField;
	private JTextArea textDescription;
	private JCheckBox chbxIsGlobal;
	private NewBehaviorDialog dialog;
	
	public BtnAddBehaviorActionListener(JTree treeScenes, Canvas canvas, JTable table, JTextField nameTextField, JTextArea textDescription, JCheckBox chbxIsGlobal, NewBehaviorDialog behaviorDialog) 
	{
		super(treeScenes, canvas, table);
		this.nameTextField= nameTextField;
		this.textDescription = textDescription;
		this.chbxIsGlobal = chbxIsGlobal;
		this.dialog = behaviorDialog;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		BehaviorFile newBehavior = new BehaviorFile(nameTextField.getText(), textDescription.getText(), chbxIsGlobal.isSelected());
		gameObject.addBehavior(newBehavior);
		this.updateTable(gameObject);
		dialog.dispose();
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}
}
