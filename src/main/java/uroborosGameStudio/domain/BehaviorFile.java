package uroborosGameStudio.domain;

import com.team.uroboros.jtypescript.engine.TypeScriptEngine;

public class BehaviorFile 
{
	private String name;
	private String description;
	private Boolean isGlobal;
	private String code;
	
	public BehaviorFile(String name, String description, Boolean isGlobal)
	{
		this.name = name;
		this.description = description;
		this.isGlobal = isGlobal;
		this.code = "";
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

	public Boolean hasName(String name) 
	{
		return this.name.equals(name);
	}

	public String getCode() 
	{
		return this.code;
	}

	public void setCode(String text) 
	{
		this.code = text;
	}

	public void evalCode(TypeScriptEngine engine) 
	{
		engine.eval(code);
	}
	
}
