package uroborosGameStudio.domain;

import javax.script.ScriptException;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Ability;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.component.Behaviour;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

public class BehaviorFile 
{
	private String name;
	private String description;
	private Boolean isGlobal;
	private String code;
	private Action type;
	
	public BehaviorFile(String name, Action type, String description, Boolean isGlobal)
	{
		this.name = name;
		this.type = type;
		this.description = description;
		this.isGlobal = isGlobal;
		this.code = "";
		this.addCode();
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

	public void learnAbility(Actor actor, EcmaScriptEngine engine) 
	{
		if (this.type == Action.ABILITY)
		{
			try {
				Ability ability = (Ability) engine.eval("new " + name + "();");
				actor.learn(ability);
			} 
			catch (ScriptException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
