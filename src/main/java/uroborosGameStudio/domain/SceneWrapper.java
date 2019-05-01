package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

public class SceneWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private List<ActorWrapper> actors;
	//private ArrayList<String> pathsActor;
	private ArrayList<String> savedActors;
	
	public SceneWrapper(String name)
	{
		this.name = name;
		this.actors = new ArrayList<ActorWrapper>();
		this.savedActors = new ArrayList<String>();
		// this.pathsActor = new ArrayList<String>();
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

	public Boolean hasName(String name2) 
	{
		return name == name2;
	}

	/*
	public BodyPath saveScene() {
		pathsActor = (ArrayList<String>) this.actors.stream().map(actor->actor.saveActor()).collect(Collectors.toList());
		pathsActor.add(0, name + ".sce");
		BodyPath path = new BodyPath(pathsActor);
		
		return path;
	}
	*/
	
	public void save(String savedPath) throws IOException
	{
		updateSavedActors();
		saveActors(savedPath);
		saveFile(savedPath);
	}
	
	public void saveFile(String savedPath) throws IOException
	{
		File file = new File(savedPath + getName() + ".sce");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
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

	private void updateSavedActors() 
	{
		setSavedActors(actors.stream().map(act -> act.getName()).collect(Collectors.toList()));
	}

	private void setSavedActors(List<String> savedActors) 
	{
		this.savedActors = (ArrayList<String>) savedActors;
	}

}
