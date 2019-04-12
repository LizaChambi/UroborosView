package uroborosGameStudio.domain;

public class DummyActors {

	Actor kids;
	Actor ball;
	Actor flow;
	
	public DummyActors()
	{
		kids = new Actor("Nene", "images/kids.png", 200, 200, 50, 120);
		ball = new Actor("Pelota", "images/ball.png", 200, 200, 50, 50);
		flow = new Actor("Piso", "images/flow.png", 0, 200, 50, 120);
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
