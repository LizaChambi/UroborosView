package uroborosGameStudio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scene implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Actor> actors= new ArrayList<Actor>();
	
	public Scene(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public List<Actor> getActors()
	{
		return this.actors;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public void addActor(Actor newActor)
	{
		actors.add(newActor);
	}
	
}
