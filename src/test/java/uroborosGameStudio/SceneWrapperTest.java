package uroborosGameStudio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;

public class SceneWrapperTest 
{
	SceneWrapper scene;
	SceneWrapper mockScene;
	ActorWrapper actor0;
	ActorWrapper actor1;
	
	@Before
	public void setUp() {
		scene = new SceneWrapper("Scene0");
		
		this.actor0 = new ActorWrapper();
		this.actor1 = new ActorWrapper();
		
		this.mockScene = mock(SceneWrapper.class);
	}
	
	@Test
	public void testCreateSceneWithName()
	{	
		assertEquals("Scene0", scene.getName());
		assertTrue(scene.getActors().isEmpty());
		assertEquals(".sce", scene.getExt());
	}
	
	@Test
	public void testMockSceneAddTwoActorsDoNothing() {	
		doNothing().when(mockScene).addActor(isA(ActorWrapper.class));
		
		mockScene.addActor(actor0);
		mockScene.addActor(actor1);
		
		verify(mockScene).addActor(actor0);
		
//		assertEquals(2, scene.cantActors().intValue());
//		assertEquals(actor1, scene.getActorIn(1));
		assertNotNull(mockScene);
		assertTrue(mockScene.getActors().isEmpty());
		assertNull(mockScene.getActorIn(0));
		assertNull(mockScene.getActorIn(1));
	}
}
