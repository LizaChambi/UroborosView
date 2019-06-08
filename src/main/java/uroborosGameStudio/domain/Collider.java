package uroborosGameStudio.domain;

import java.io.Serializable;
import java.util.function.Consumer;

import javax.script.ScriptException;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;

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

	public void evalCollider(EcmaScriptEngine engine, String nameActor) 
	{
		Actor actor = Game.getActor(nameActor);
		Consumer<Actor> collider;
		try {
			collider = (Consumer<Actor>) engine.eval(code);
			actor.whenCollidesDo(collider);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
