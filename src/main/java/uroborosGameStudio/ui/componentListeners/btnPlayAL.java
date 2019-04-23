package uroborosGameStudio.ui.componentListeners;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.geometry.Point;
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
			public void run() {
				// TODO Auto-generated method stub
				Game.setCustomCanvas(canvas);
				SpriteSheet spritesheet = new SpriteSheet("kids.png", new Frame(new Point(0,0), new org.team.uroboros.uroboros.engine.geometry.Dimension(257, 512)));
				Sprite sprite= new Sprite(spritesheet, 0, new org.team.uroboros.uroboros.engine.geometry.Dimension(80, 150));
				Game.createScene("Escena inicial");
				Game.setScene("Escena inicial");
				org.team.uroboros.uroboros.engine.Actor pepe = Game.createActor("Pepe");
				pepe.learn(new RenderTexture(sprite));
				Game.start();
			}
		};
		t.start();
	}

}
