package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTree;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.ConfigureAnimationDialog;

public class OpenEditSpriteSheetActionListener implements ActionListener 
{
	private JTree treeScenes;
	private Canvas canvas;
	private MainWindowModel model;
	
	public OpenEditSpriteSheetActionListener(JTree treeScenes, Canvas canvas, MainWindowModel model) 
	{
		this.canvas = canvas;
		this.treeScenes = treeScenes;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		ConfigureAnimationDialog dialog = new ConfigureAnimationDialog(treeScenes, canvas, model);
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);	
	}

}
