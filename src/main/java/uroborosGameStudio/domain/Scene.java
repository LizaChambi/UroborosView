package uroborosGameStudio.domain;

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
		this.actors.add(new Actor("Actor1"));
		this.actors.add(new Actor("Actor2"));
		this.actors.add(new Actor("Actor3"));
	}

	public String getName() 
	{
		return this.name;
	}

	public Integer cantActors() 
	{
		return this.actors.size();
	}

	public Actor getActorIn(Integer index) 
	{
		return this.actors.get(index);
	}
}
