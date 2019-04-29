package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.GameObject;

public abstract class AbstractEditionListener implements ActionListener, TreeSelectionListener
{
	public JTree treeScenes;
	
	public AbstractEditionListener(JTree treeScenes)
	{
		this.treeScenes = treeScenes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		updateSelectedItem();
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) 
	{
		updateSelectedItem();
	}
	
	public void updateSelectedItem()
	{
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		GameObject gameObject = (GameObject) selectedNode.getUserObject();
		updateComponents(gameObject);
		updateComponents();
	}

	public abstract void updateComponents(GameObject gameObject);

	public abstract void updateComponents();

}
