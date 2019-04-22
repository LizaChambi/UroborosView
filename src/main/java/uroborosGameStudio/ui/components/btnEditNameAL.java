package uroborosGameStudio.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.Actor;
import uroborosGameStudio.domain.Scene;
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		
		if(selectedNode.getUserObject().getClass() == UGSProject.class)
		{
			UGSProject obj = (UGSProject) selectedNode.getUserObject();
			obj.setTitle(textField.getText());
		}
		if(selectedNode.getUserObject().getClass() == Scene.class)
		{
			Scene obj = (Scene) selectedNode.getUserObject();
			obj.setName(textField.getText());
		}
		if(selectedNode.getUserObject().getClass() == Actor.class)
		{
			Actor obj = (Actor) selectedNode.getUserObject();
			obj.setName(textField.getText());
		}
		treeScenes.updateUI();
	}

}
