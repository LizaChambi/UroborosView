package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.ui.components.ActorsPanel;

public class BtnPlayAL implements ActionListener 
{
	private Canvas canvas;
	private ActorsPanel panel;
	private JPanel playPanel;
	
	public BtnPlayAL(Canvas canvas, ActorsPanel actorsPanel, JPanel playPanel) 
	{
		this.canvas = canvas;
		this.panel = actorsPanel;
		this.playPanel = playPanel;
	}

	public void actionPerformed(ActionEvent e) 
	{
		panel.setVisible(false);
		playPanel.updateUI();
		playPanel.add(canvas);
		Thread t = new Thread() 
		{	
			@Override
			public void run() 
			{
				Game.start(canvas);
			}
		};
		t.start();
	}
}
