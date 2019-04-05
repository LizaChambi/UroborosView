package uroborosGameStudio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Scene> scenes= new ArrayList<Scene>();
	
	public Game(String name)
	{
		this.name= name;
		addScene("scene1");
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public List<Scene> getScenes()
	{
		return this.scenes;
	}

	private void addScene(String name)
	{
		this.scenes.add(new Scene(name));
	}
	
	
}
