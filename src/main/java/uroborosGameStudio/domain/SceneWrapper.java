package uroborosGameStudio.domain;

import java.io.IOException;
import java.io.Serializable;
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

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class SceneWrapper extends GameObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<ActorWrapper> actors;
	
	public SceneWrapper(String name)
	{
		this.name = name;
		this.ext = ".sce";
		this.actors = new ArrayList<ActorWrapper>();
	}

	public List<ActorWrapper> getActors()
	{
		return this.actors;
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
			public void onRender(Graphics graphics) { }

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

	@Override
	public void setName(String newName) {
		if(newName.equals("")) throw new NombreVacioException(this);
		Game.rename(Game.getScene(name), newName);
		this.name = newName;
	}

	public Boolean hasName(String name2) 
	{
		return name == name2;
	}

	public void save(String savedPath) throws IOException
	{
		saveActors(savedPath);
		saveFile(savedPath);
	}

	private void saveActors(String savedPath)
	{
		this.actors.forEach(act -> {
			try 
			{
				act.saveFile(savedPath);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Override
	public void setSceneUEngine() 
	{
		Game.setScene(this.name);
	}

	@Override
	public SceneWrapper selectedScene(MainWindowModel model) 
	{
		return this;
	}

	@Override
	public void setPosition(Integer x, Integer y) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public Integer getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
