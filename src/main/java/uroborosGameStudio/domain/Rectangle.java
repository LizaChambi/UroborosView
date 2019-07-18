package uroborosGameStudio.domain;

import java.io.Serializable;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.physics.material.BoxMaterial;
import org.team.uroboros.uroboros.engine.physics.material.PhysicsMaterial;

public class Rectangle extends Body implements Serializable 
{
	private static final long serialVersionUID = 1L;

	public Rectangle() {
		super("Ractángulo");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPhysicsBodyUEngine(ActorWrapper actorWpp) 
	{
		Actor actor = Game.getActorOnCurrentScene(actorWpp.getName());
		PhysicsMaterial body = new BoxMaterial(actorWpp.getWidth(), actorWpp.getHeight(), PhysicsMaterial.DEFAULT_FRICTION, PhysicsMaterial.DEFAULT_RESTITUTION, PhysicsMaterial.DEFAULT_DENSITY);
		actor.addPhysicsMaterial(body);
	}

}
