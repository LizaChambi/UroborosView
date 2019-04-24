package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.team.uroboros.uroboros.engine.Ability;
import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.input.Key;
import org.team.uroboros.uroboros.engine.ui.Graphics;
import org.team.uroboros.uroboros.engine.ui.RenderTexture;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;

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
