package uroborosGameStudio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.Actor;

public class ActorTest 
{
	Actor actor;
	
	@Before
	public void setUp()
	{
		actor = new Actor("Actor0");
	}
	
	@Test
	public void testCreateActorWithName()
	{	
		assertEquals("Actor0", actor.getName());
	}
}
