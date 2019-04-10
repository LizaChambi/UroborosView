package uroborosGameStudio.domain;

public class DummyActors 
{
	private Actor kids;
	private Actor ball;
	private Actor flow;
	
	public DummyActors()
	{
		this.ball = new Actor("Pelota", "images/ball.png", 200, 200, 50, 50);
		this.kids = new Actor("Nene", "images/kids.png", 200, 200, 50, 120);
		this.flow = new Actor("Piso", "images/flow.png", 0, 200, 50, 120);
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
