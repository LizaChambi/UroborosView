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
		verify(mockScene).addActor(actor1);
		
		assertNotNull(mockScene);
		assertTrue(mockScene.getActors().isEmpty());
		assertNull(mockScene.getActorIn(0));
		assertNull(mockScene.getActorIn(1));
	}
	
//	@Test
//	public void testMockSceneAddActorDoAnswer() {
//		
//	}
	
	@Test
	public void testSetNameDoNothing() {
		doNothing().when(mockScene).setName(isA(String.class));
		mockScene.setName("Main Scene");
		
		verify(mockScene).setName("Main Scene");
		
		assertNotNull(mockScene);
		assertNull(mockScene.getName());
	}
	
	@Test (expected = RuntimeException.class)
	public void testMockSceneSetNameEmpty() {
		doThrow().when(mockScene).setName(isA(String.class));
		mockScene.setName("");
		
		assertEquals("owijwoiejff", mockScene.getName());
	}
	
	@Test (expected = RuntimeException.class)
	public void testSetNameEmpty() {
		scene.setName("");
		
		assertEquals("qwqwfhuhqfh", scene.getName());
	}
	
	
	
}
