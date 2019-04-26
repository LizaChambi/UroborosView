package uroborosGameStudio.domain;

import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Ability;
import org.team.uroboros.uroboros.engine.Actor;
import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.input.Key;
import org.team.uroboros.uroboros.engine.ui.Graphics;
import org.team.uroboros.uroboros.engine.ui.RenderTexture;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;

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
	
	public void addActor(ActorWrapper actorWpp)
	{
		this.actors.add(actorWpp);
		Actor newActor = Game.createActor(actorWpp.getName());
		
		SpriteSheet spritesheet = new SpriteSheet(actorWpp.getPath(), new Frame(new Point(0,0), new Dimension(actorWpp.getRealWidth(), actorWpp.getRealHeight())));
		Sprite sprite= new Sprite(spritesheet, 0, new Dimension(actorWpp.getWidth(), actorWpp.getHeight()));
		newActor.learn(new RenderTexture(sprite));
		newActor.translate(new Point(actorWpp.getX(), actorWpp.getY()));
		
		newActor.learn(new Ability() 
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
		Game.rename(Game.getScene(name), newName);
		this.name = newName;
	}
	
	
}
