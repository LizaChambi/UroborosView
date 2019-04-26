package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

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
		
		if(selectedNode.getUserObject().getClass() == UGSProject.class)
		{
			UGSProject ugsGame = (UGSProject) selectedNode.getUserObject();
			updateProject(ugsGame);
		}
		if(selectedNode.getUserObject().getClass() == SceneWrapper.class)
		{
			SceneWrapper sceneWpp = (SceneWrapper) selectedNode.getUserObject();
			updateScene(sceneWpp);
		}
		if(selectedNode.getUserObject().getClass() == ActorWrapper.class)
		{
			ActorWrapper actorWpp = (ActorWrapper) selectedNode.getUserObject();
			updateActor(actorWpp);
		}
		updateComponents();
	}

	public abstract void updateComponents();

	public abstract void updateActor(ActorWrapper actorWpp);

	public abstract void updateScene(SceneWrapper sceneWpp);

	public abstract void updateProject(UGSProject ugsGame);
	
}
