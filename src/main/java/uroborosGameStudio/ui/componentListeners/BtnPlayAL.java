package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.ui.Canvas;
import org.team.uroboros.uroboros.engine.ui.TextureRenderer;
import org.team.uroboros.uroboros.engine.ui.resources.Animation;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;
import org.team.uroboros.uroboros.engine.ui.resources.Texture;

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
				model.evalBehaviorsAndCollisions();
				model.playAudio();
				/*
				Actor newActor = Game.createActor("Disparo");
				SpriteSheet spritesheet = new SpriteSheet("/home/chambi_liza/Descargas/resources/thruster.png", new Frame(new Point(0,0), new Dimension(50, 178)), new Frame(new Point(50,0), new Dimension(50, 178)),new Frame(new Point(100,0), new Dimension(50, 178)), new Frame(new Point(150,0), new Dimension(50, 178)));
				Texture sprite = new Animation(spritesheet, 2,0,1,2,3); //lista de los indices que usa la animacion. El 2do numero mientras mas grande más lento
				newActor.setDimension(new Dimension(20, 100));
				newActor.setTexture(sprite);
				newActor.learn(new TextureRenderer());
				*/
				
				Game.start(canvas);
			}
		};
		t.start();
	}
}
