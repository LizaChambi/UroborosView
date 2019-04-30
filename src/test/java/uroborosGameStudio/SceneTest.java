package uroborosGameStudio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;

public class SceneTest 
{
	SceneWrapper scene;
	
	@Before
	public void setUp()
	{
		scene = new SceneWrapper("Scene0");
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
		ActorWrapper actor0 = new ActorWrapper("Actor0", "images/kids.png", 12, 15, 59, 89);
		ActorWrapper actor1 = new ActorWrapper("Actor1", "images/kids.png", 12, 15, 59, 89);
		scene.addActor(actor0);
		scene.addActor(actor1);
		
		assertEquals(2, scene.cantActors().intValue());
		assertEquals(actor1, scene.getActorIn(1));
	}
}
