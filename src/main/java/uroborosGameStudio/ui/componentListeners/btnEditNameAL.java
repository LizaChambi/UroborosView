package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class btnEditNameAL implements ActionListener 
{
	private JTree treeScenes;
	private JTextField textField;

	public btnEditNameAL(JTree treeScenes, JTextField textField) 
	{
		this.treeScenes = treeScenes;
		this.textField = textField;
	}

	public void actionPerformed(ActionEvent e) 
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		
		if(selectedNode.getUserObject().getClass() == UGSProject.class)
		{
			UGSProject obj = (UGSProject) selectedNode.getUserObject();
			obj.setTitle(textField.getText());
		}
		if(selectedNode.getUserObject().getClass() == SceneWrapper.class)
		{
			SceneWrapper obj = (SceneWrapper) selectedNode.getUserObject();
			obj.setName(textField.getText());
		}
		if(selectedNode.getUserObject().getClass() == ActorWrapper.class)
		{
			ActorWrapper obj = (ActorWrapper) selectedNode.getUserObject();
			obj.setName(textField.getText());
		}
		treeScenes.updateUI();
	}

}
