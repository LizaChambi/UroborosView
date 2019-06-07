package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.script.ScriptException;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Ability;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.component.Behaviour;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

public class BehaviorFile implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private Boolean isGlobal;
	private String code;
	private Action type;
	private String ext;
	
	public BehaviorFile(String name, Action type, String description, Boolean isGlobal)
	{
		this.name = name;
		this.type = type;
		this.description = description;
		this.isGlobal = isGlobal;
		this.code = "";
		this.addCode();
		this.ext = ".adm";
	}
	
	private void addCode() 
	{
		switch(this.type)
		{
		case BEHAVIOR:
			this.code = behaviorCode() ;
			break;
		case ABILITY:
			this.code = abilityCode() ;
			break;
		}
	}

	private String abilityCode() {
		return "Java.extend(Ability, {\n" + 
				"\n" + 
				"	onStart: function (actor) {\n" + 
				"		 this.actor = actor;\n" + 
				"	},\n" + 
				"\n" + 
				"	onUpdate: function (deltaTime) {\n" + 
				"	\n" + 
				"	},\n" + 
				"\n" + 
				"	onRender: function (graphics) {\n" + 
				"	 \n" + 
				"	},\n" + 
				"	\n" + 
				"});";
	}

	private String behaviorCode() {
		return "Java.extend(Behaviour, {\n" + 
				"\n" + 
				"	onStart: function (actor) {\n" + 
				"		 this.actor = actor;\n" + 
				"	},\n" + 
				"\n" + 
				"	onUpdate: function (deltaTime) {\n" + 
				"	\n" + 
				"	},\n" + 
				"\n" + 
				"});";
	}

	public Action getType() {
		return this.type;
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

	public void evalCode(EcmaScriptEngine engine, ActorWrapper actorWrapper) 
	{	
		switch(this.type)
		{
		case BEHAVIOR:
			
			try 
			{
				engine.eval("var " + name + " = " + code);
			} 
			catch (ScriptException e) 
			{
				// TODO Auto-generated catchs block
				e.printStackTrace();
			}
			
			System.out.println("Comportamiento");
			break;
			
		case ABILITY:
			try 
			{
				engine.eval("var " + name + " = " + code);
				//Ability ability =(Ability) engine.eval("new " + name + "();");
				//Actor actor = Game.getActor(actorWrapper.getName());
				// actor.learn(ability);
			} 
			catch (ScriptException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public String getTypeView() 
	{
		String typeView = "Habilidad";
		if(this.type.equals(Action.BEHAVIOR))
		{
			typeView = "Comportamiento";
		}
		return typeView;
	}

	public void learnAbility(Actor actor, EcmaScriptEngine engine, String pathAbility) 
	{
		if (this.type == Action.ABILITY)
		{
			try {
				Ability ability = (Ability) engine.eval("new " + name + "();");
				
				saveFile(pathAbility);
				
				actor.learn(ability);
			} 
			catch (ScriptException | IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void saveFile(String savedPath) throws IOException {
		File file = new File(savedPath + getName() + getExt());
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}

	private String getExt() { return this.ext; }
	
}
