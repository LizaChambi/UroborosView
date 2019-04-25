package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class btNewSceneAL implements ActionListener 
{
	private JTree treeScenes;
	private Integer idScene;
	
	public btNewSceneAL(JTree treeScenes, int idScene) 
	{
		this.treeScenes = treeScenes;
		this.idScene = idScene;
	}

	public void actionPerformed(ActionEvent e) 
	{
		addScene();
	}

	private void addScene() 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
			if(lastNode.getLevel() == 0)
			{
				UGSProject game = (UGSProject) lastNode.getUserObject();
				SceneWrapper newScene = new SceneWrapper("Escena" + this.idScene);
				game.addScene(newScene);
				modelNode.insertNodeInto(new DefaultMutableTreeNode(newScene), lastNode, modelNode.getChildCount(lastNode));
				this.idScene++;
			}
		}
	}

}
