package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnPlayAL implements ActionListener 
{
	private Canvas canvas;
	private MainWindowModel model;
	
	public BtnPlayAL(Canvas canvas, MainWindowModel model) 
	{
		this.canvas = canvas;
		this.model = model;
	}

	public void actionPerformed(ActionEvent e) 
	{
		Thread t = new Thread() 
		{	
			@Override
			public void run() 
			{
				model.evalBehaviors();
				Game.start(canvas);
			}
		};
		t.start();
	}
}
