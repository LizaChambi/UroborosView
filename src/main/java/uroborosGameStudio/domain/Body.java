package uroborosGameStudio.domain;

import java.io.Serializable;

public abstract class Body implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public Body(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	abstract public void setPhysicsBodyUEngine(ActorWrapper actorWrapper);

}
