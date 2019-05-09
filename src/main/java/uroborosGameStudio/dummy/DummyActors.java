package uroborosGameStudio.dummy;
import uroborosGameStudio.domain.ActorWrapper;

public class DummyActors {

	ActorWrapper kids;
	ActorWrapper ball;
	ActorWrapper flow;
	
	public DummyActors()
	{
		kids = new ActorWrapper("Nene", "src/main/resources/kids.png", 110, 150, 50, 120);
		ball = new ActorWrapper("Pelota", "src/main/resources/ball.png", 220, 220, 40, 40);
		flow = new ActorWrapper("Piso", "src/main/resources/flow.png", 0, 270, 335, 30);
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
