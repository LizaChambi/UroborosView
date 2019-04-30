package uroborosGameStudio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.ActorWrapper;

public class ActorTest 
{
	ActorWrapper actor;
	
	@Before
	public void setUp()
	{
		actor = new ActorWrapper("Actor0", "images/kids.png", 12, 15, 59, 89);
	}
	
	@Test
	public void testCreateActorWithName()
	{	
		assertEquals("Actor0", actor.getName());
	}
}
