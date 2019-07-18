package uroborosGameStudio.domain;

import java.io.Serializable;

import javax.script.ScriptException;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Behaviour;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

public class Collider implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private String code;
	
	public Collider(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.code = behaviorCode();
	}

	private String behaviorCode() 
	{
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

	@SuppressWarnings("unchecked")
	public void evalCollider(EcmaScriptEngine engine, String nameActor) 
	{
		try {
			engine.eval("var " + name + " = " + this.code);
			Behaviour behaviour = (Behaviour) engine.eval("new " + name + "();");
			Game.getActor(nameActor).whenCollidesDo(behaviour);
		} catch (ScriptException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
