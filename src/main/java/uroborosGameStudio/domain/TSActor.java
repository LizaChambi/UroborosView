package uroborosGameStudio.domain;

import org.team.uroboros.uroboros.engine.component.Ability;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.ui.Graphics;

public class TSActor extends Actor
{
	public TSActor(String name) 
	{
		super(name);
	}
	
	@SuppressWarnings("restriction")
	public void learn(jdk.nashorn.api.scripting.ScriptObjectMirror abilityScript) 
	{
		Ability ability = new Ability() {

			@Override
			public void onStart(Actor actor) {
				abilityScript.callMember("onStart", actor);
			}

			@Override
			public void onUpdate(Double deltaTime) {
				abilityScript.callMember("onUpdate", deltaTime);
			}

			@Override
			public void onRender(Graphics graphics) {
				abilityScript.callMember("onRender", graphics);
			}
		};
		this.learn(ability);
		ability.onStart(this);
	}
}
