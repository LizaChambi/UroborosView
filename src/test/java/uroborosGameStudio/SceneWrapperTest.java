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
		String path = "D:\\Gabriel\\TIP\\repoOrganization\\UroborosGameStudio\\src\\main\\resources\\";
		this.actor0 = new ActorWrapper("Actor0",path + "kids.png", 12, 15, 59, 89);
		this.actor1 = new ActorWrapper();

		scene = new SceneWrapper("Scene0");
		
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
	
	@Test
	public void testMockSceneAddActorDoAnswer() {
		doAnswer((i)-> {
			assertTrue(actor0.equals(i.getArgument(0)));
			return null;
		}).when(mockScene).addActor(actor0);
		
		when(mockScene.getActorIn(0)).thenReturn(actor0);
		
		mockScene.addActor(actor0);
		assertEquals(actor0, mockScene.getActorIn(0));
		assertTrue(mockScene.getActors().isEmpty());
	}
	
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
	
	@Test
	public void testMockSceneSetNameDoAnswer() {
		doAnswer((i)->{
			assertTrue("Main Scene".equals(i.getArgument(0)));
			return null;
		}).when(mockScene).setName(anyString());
		
		when(mockScene.getName()).thenReturn("Main Scene");
		
		mockScene.setName("Main Scene");
		assertEquals("Main Scene", mockScene.getName());
	}
	
	@Test
	public void testDeleteActorByName() {
		doAnswer((i)-> {
			assertTrue(actor0.equals(i.getArgument(0)));
			return null;
		}).when(mockScene).addActor(actor0);
	
		when(mockScene.getActorIn(0)).thenReturn(actor0);
		when(mockScene.cantActors()).thenReturn(1);
		
		mockScene.addActor(actor0);
		
		assertEquals(actor0, mockScene.getActorIn(0));
		assertTrue(1 == mockScene.cantActors());
	
		doAnswer((i)-> {
			assertTrue(actor0.getName().equals(i.getArgument(0)));
			return null;
		}).when(mockScene).deleteActor(actor0.getName());
		
		mockScene.deleteActor(actor0.getName());
		
		assertTrue(mockScene.getActors().isEmpty());
	}
	
}
