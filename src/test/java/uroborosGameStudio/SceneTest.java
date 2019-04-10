package uroborosGameStudio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.Actor;
import uroborosGameStudio.domain.Scene;

public class SceneTest 
{
	Scene scene;
	
	@Before
	public void setUp()
	{
		scene = new Scene("Scene0");
	}
	
	@Test
	public void testCreateSceneWithName()
	{	
		assertEquals("Scene0", scene.getName());
		assumeTrue(scene.getActors().isEmpty());
	}
	
	@Test
	public void testCreateSceneWithTwoActorsAndGetTheSecond()
	{	
		Actor actor0 = new Actor("Actor0");
		Actor actor1 = new Actor("Actor1");
		scene.addActor(actor0);
		scene.addActor(actor1);
		
		assertEquals(2, scene.cantActors().intValue());
		assertEquals(actor1, scene.getActorIn(1));
	}
}
