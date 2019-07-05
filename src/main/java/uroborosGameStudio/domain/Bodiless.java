package uroborosGameStudio.domain;

import java.io.Serializable;

public class Bodiless extends Body implements Serializable {

	private static final long serialVersionUID = 1L;

	public Bodiless() {
		super("");
	}

	@Override
	public void setPhysicsBodyUEngine(ActorWrapper actor) {}

}
