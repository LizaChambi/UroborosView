package uroborosGameStudio.domain;

public class DummyActors 
{
	private int idKids;
	private int idBall;
	private int idFlow;
	
	public DummyActors()
	{
		idKids = 0;
		idBall = 0;
		idFlow = 0;
	}
	
	public Actor getKids()
	{
		this.idKids++;
		return new Actor("Nene" + idKids, "images/kids.png", 200, 200, 50, 120);
	}
	
	public Actor getBall()
	{
		this.idBall++;
		return new Actor("Pelota" + idBall, "images/ball.png", 200, 200, 50, 50);
	}
	
	public Actor getFlow()
	{
		this.idFlow++;
		return new Actor("Piso" + idFlow, "images/flow.png", 0, 200, 50, 120);
	}
	
}
