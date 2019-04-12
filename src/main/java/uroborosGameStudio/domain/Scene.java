package uroborosGameStudio.domain;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Scene 
{
	private String name;
	private List<Actor> actors;
	
	public Scene(String name)
	{
		this.name = name;
		this.actors = new ArrayList<Actor>();
	}

	public List<Actor> getActors()
	{
		return this.actors;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void addActor(Actor actor)
	{
		this.actors.add(actor);
		for(int i=0; i<cantActors();i++)
		{
			System.out.println(getActorIn(i).getName());
		}
	}

	public Integer cantActors() 
	{
		return this.actors.size();
	}

	public Actor getActorIn(Integer index) 
	{
		return this.actors.get(index);
	}

	@Override
	public String toString() 
	{
		return this.name;
	}
	
	
}
