package uroborosGameStudio.domain.appModel;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;

public class BtnNewActorAL implements ActionListener 
{
	private JTree treeScenes;
	private JComboBox<ActorWrapper> comboBox;
	private Canvas canvas;
	
	public BtnNewActorAL(JTree treeScenes, JComboBox<ActorWrapper> comboBox, Canvas canvas) 
	{
		this.treeScenes = treeScenes;
		this.comboBox = comboBox;
		this.canvas = canvas;
	}

	public void actionPerformed(ActionEvent e) 
	{
		ActorWrapper newActor = (ActorWrapper) comboBox.getSelectedItem();
		addActor(newActor);
		drawNewActor(newActor);
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
