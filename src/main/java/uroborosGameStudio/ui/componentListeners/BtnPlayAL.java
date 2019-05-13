package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

public class BtnPlayAL implements ActionListener 
{
	private Canvas canvas;
	
	public BtnPlayAL(Canvas canvas) 
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
				Game.start(canvas);
			}
		};
		t.start();
	}
}
