package uroborosGameStudio.domain;

public abstract class GameObject {

	String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {};
	
	public String getName(String name) {
		return this.name;
	}

}
