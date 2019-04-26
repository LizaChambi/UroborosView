package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.team.uroboros.uroboros.engine.Game;

public class btnPlayAL implements ActionListener 
{
	private Canvas canvas;
	
	public btnPlayAL(Canvas canvas) 
	{
		this.canvas = canvas;
	}

	public void actionPerformed(ActionEvent e) 
	{
		Thread t = new Thread() 
		{	
			@Override
			public void run() 
			{
				Game.setCustomCanvas(canvas);
				Game.start();
			}
		};
		t.start();
	}

}
