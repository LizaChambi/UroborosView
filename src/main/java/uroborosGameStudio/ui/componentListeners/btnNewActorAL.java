package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;

public class btnNewActorAL implements ActionListener 
{
	private JTree treeScenes;
	private JComboBox<ActorWrapper> comboBox;
	private Canvas canvas;
	private JButton btnPlay;
	
	public btnNewActorAL(JTree treeScenes, JComboBox<ActorWrapper> comboBox, Canvas canvas, JButton btnPlay) 
	{
		this.treeScenes = treeScenes;
		this.comboBox = comboBox;
		this.canvas = canvas;
		this.btnPlay = btnPlay;
	}

	public void actionPerformed(ActionEvent e) 
	{
		ActorWrapper newActor = (ActorWrapper) comboBox.getSelectedItem();
		addActor(newActor);
		drawNewActor(newActor);
		btnPlay.setEnabled(true);
	}

	private void drawNewActor(ActorWrapper actor) 
	{
		canvas.getGraphics().drawImage(actor.getImage(), actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight(), null);
	}

	private void addActor(ActorWrapper actorWpp) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
			if(lastNode.getLevel() == 1)
			{
				SceneWrapper scene = (SceneWrapper) lastNode.getUserObject();
				scene.addActor(actorWpp);
				modelNode.insertNodeInto( new DefaultMutableTreeNode(actorWpp), lastNode, modelNode.getChildCount(lastNode));
			}
		}
	}
	
	

}
