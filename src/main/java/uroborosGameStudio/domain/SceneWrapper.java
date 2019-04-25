package uroborosGameStudio.domain;

import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Ability;
import org.team.uroboros.uroboros.engine.Actor;
import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.input.Key;
import org.team.uroboros.uroboros.engine.ui.Graphics;
import org.team.uroboros.uroboros.engine.ui.RenderTexture;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;
import org.team.uroboros.uroboros.engine.geometry.Dimension;

public class SceneWrapper 
{
	private String name;
	private List<ActorWrapper> actors;
	
	public SceneWrapper(String name)
	{
		this.name = name;
		this.actors = new ArrayList<ActorWrapper>();
	}

	public List<ActorWrapper> getActors()
	{
		return this.actors;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void addActor(ActorWrapper actor)
	{
		this.actors.add(actor);
		Actor pepe = Game.createActor(actor.getName());
		
		SpriteSheet spritesheet = new SpriteSheet(actor.getPath(), new Frame(new Point(0,0), new Dimension(actor.getRealWidth(), actor.getRealHeight())));
		Sprite sprite= new Sprite(spritesheet, 0, new Dimension(actor.getWidth(), actor.getHeight()));
		pepe.learn(new RenderTexture(sprite));
		pepe.translate(new Point(actor.getX(), actor.getY()));
		
		pepe.learn(new Ability() 
		{	
			Actor actor;
			
			@Override
			public void onStart(Actor actor) 
			{
				this.actor =actor;
			}
			
			@Override
			public void onUpdate(Double deltaTime) 
			{
				if(Key.UP.isPressed()) 
				{
					this.actor.translate(0, 3);
				}
				if(Key.RIGHT.isPressed()) 
				{
					this.actor.translate(3, 0);
				}
				if(Key.DOWN.isPressed()) 
				{
					this.actor.translate(0, -3);
				}
				if(Key.LEFT.isPressed()) 
				{
					this.actor.translate(-3, 0);
				}
			}
			
			@Override
			public void onRender(Graphics graphics) 
			{
				// TODO Auto-generated method stub	
			}
		});
	}

	public Integer cantActors() 
	{
		return this.actors.size();
	}

	public ActorWrapper getActorIn(Integer index) 
	{
		return this.actors.get(index);
	}

	@Override
	public String toString() 
	{
		return this.name;
	}

	public void setName(String newName) 
	{
		this.name = newName;
	}
	
	
}
