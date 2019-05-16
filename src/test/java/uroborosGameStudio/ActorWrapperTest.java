package uroborosGameStudio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.ActorWrapper;

public class ActorWrapperTest {

	ActorWrapper actor;

	ActorWrapper pepe;
	
	@Before
	public void setUp() {
		String path = "D:\\Gabriel\\TIP\\repoOrganization\\UroborosGameStudio\\src\\main\\resources\\";
		this.actor = new ActorWrapper("Actor0",path + "kids.png", 12, 15, 59, 89);

		this.pepe = mock(ActorWrapper.class);
	}

	@Test
	public void testCreateActorOK() 
	{
		assertEquals("Actor0", actor.getName());
		assertEquals(".act", actor.getExt());
		assertEquals(new Point(12, 15), actor.point);
		assertEquals(new Dimension(59, 89), actor.dimension);
		
	}
	
	@Test
	public void testEditedNameDoNothing() {
		doNothing().when(pepe).setName(isA(String.class));
		pepe.setName("pepe");
		
		verify(pepe).setName("pepe");
		
		assertNotNull(pepe);
		assertNull(this.pepe.getName());
	}
	
	@Test(expected = RuntimeException.class)
	public void testMockSetNameEmpty() {
		doThrow().when(pepe).setName(isA(String.class));
		
		pepe.setName("");
		assertEquals("qwqwfkejnrfkwejnf", this.pepe.getName());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetNameEmpty() {
		this.actor.setName("");
		
		assertEquals("qwdthrtewwewe", actor.getName());
	}
	
	@Test
	public void testSetNewNameDoAnswer() {
		doAnswer((i)->{
			assertTrue("Alan".equals(i.getArgument(0)));
			return null;
		}).when(pepe).setName(anyString());
		
		when(pepe.getName()).thenReturn("Alan");
		
		pepe.setName("Alan");
		assertEquals("Alan", pepe.getName());
	}
	
	@Test
	public void testSetPositionOK() {
		Point pino = new Point(45, 89);
		actor.setPosition(pino.x, pino.y);
		
		assertEquals(pino, actor.point);
	}
	
}
