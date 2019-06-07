package uroborosGameStudio.domain;

public class Collider 
{
	private String name;
	private String description;
	private String code;
	
	public Collider(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.code = "";
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String newCode) {
		this.code = newCode;
	}
}
