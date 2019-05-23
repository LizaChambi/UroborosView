package uroborosGameStudio.domain;

public class BehaviorFile 
{
	private String name;
	private String description;
	private Boolean isGlobal;
	
	public BehaviorFile(String name, String description, Boolean isGlobal)
	{
		this.name = name;
		this.description = description;
		this.isGlobal = isGlobal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public Boolean hasName(String name2) 
	{
		return this.name.equals(name2);
	}
	
}
