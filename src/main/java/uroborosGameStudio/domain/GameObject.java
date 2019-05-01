package uroborosGameStudio.domain;

import java.io.Serializable;

public abstract class GameObject implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name = "";

	public String getName()
	{
		return this.name;
	}

	public abstract void setName(String name);

}
