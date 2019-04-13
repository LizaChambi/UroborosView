package uroborosGameStudio.dummy;
import uroborosGameStudio.domain.Actor;

public class DummyActors {

	Actor kids;
	Actor ball;
	Actor flow;
	
	public DummyActors()
	{
		kids = new Actor("Nene", "src/main/resources/kids.png", 110, 150, 50, 120);
		ball = new Actor("Pelota", "src/main/resources/ball.png", 220, 220, 40, 40);
		flow = new Actor("Piso", "src/main/resources/flow.png", 0, 270, 335, 30);
	}
	
	public Actor getKids()
	{
		return this.kids;
	}
	
	public Actor getBall()
	{
		return this.ball;
	}
	
	public Actor getFlow()
	{
		return this.flow;
	}
}
