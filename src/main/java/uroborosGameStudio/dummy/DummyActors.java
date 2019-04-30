package uroborosGameStudio.dummy;
import uroborosGameStudio.domain.ActorWrapper;

public class DummyActors {

	ActorWrapper kids;
	ActorWrapper ball;
	ActorWrapper flow;
	
	public DummyActors()
	{
		kids = new ActorWrapper("Nene", "kids.png", 110, 150, 50, 120);
		ball = new ActorWrapper("Pelota", "ball.png", 220, 220, 40, 40);
		flow = new ActorWrapper("Piso", "flow.png", 0, 270, 335, 30);
	}
	
	public ActorWrapper getKids()
	{
		return this.kids;
	}
	
	public ActorWrapper getBall()
	{
		return this.ball;
	}
	
	public ActorWrapper getFlow()
	{
		return this.flow;
	}
}
