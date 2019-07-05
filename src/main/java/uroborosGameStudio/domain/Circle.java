package uroborosGameStudio.domain;

import java.io.Serializable;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.physics.material.PhysicsMaterial;
import org.team.uroboros.uroboros.engine.physics.material.SphereMaterial;

public class Circle extends Body implements Serializable  {

	private static final long serialVersionUID = 1L;

	public Circle() {
		super("Círculo");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPhysicsBodyUEngine(ActorWrapper actorWpp) 
	{
		Actor actor = Game.getActorOnCurrentScene(actorWpp.getName());
		PhysicsMaterial body = new SphereMaterial(actorWpp.getDimension().getWidth() * 0.5, PhysicsMaterial.DEFAULT_FRICTION, PhysicsMaterial.DEFAULT_RESTITUTION, PhysicsMaterial.DEFAULT_DENSITY);
		actor.addPhysicsMaterial(body);
	}

}
