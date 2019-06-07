package uroborosGameStudio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.Action;
import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.BehaviorFile;
import uroborosGameStudio.domain.Physics;

public class ActorWrapperTest {

	ActorWrapper actor;
	ActorWrapper pepe;
	
	@Before
	public void setUp() {
		String path = "src/main/resources/";
		this.actor = new ActorWrapper("Actor0", path + "kids.png", 12, 15, 59, 89);

		this.pepe = mock(ActorWrapper.class);
	}

	@Test
	public void testCreateActorOK() 
	{
		assertEquals("Actor0", actor.getName());
		assertEquals(".act", actor.getExt());
		assertEquals(new Point(12, 15), actor.getPosition());
		assertEquals(new Dimension(59, 89), actor.getDimension());
		assertTrue(actor.getBehaviors().isEmpty());
		assertTrue(actor.getColliders().isEmpty());
		assertTrue(actor.getBody().equals("Rectángulo"));
		assertTrue(actor.getColliders().isEmpty());
		assertEquals(Physics.STATIC, actor.getPhysicsType());
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
		assertEquals("Alan", this.pepe.getName());
	}
	
	@Test(expected = RuntimeException.class)
	public void testSetNameEmpty() {
		this.actor.setName("");
		
		assertEquals("Pepe", actor.getName());
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
	public void testSetPositionDoNothing() {
		Point newPoint = new Point(45, 89);
		doNothing().when(pepe).setPosition(isA(Integer.class), isA(Integer.class));
		pepe.setPosition(newPoint.x, newPoint.y);
		
		verify(pepe).setPosition(newPoint.x, newPoint.y);
		
		assertNotNull(pepe);
		assertNull(pepe.getPosition());
	}
	
	@Test
	public void testCreateActorAndAddBehavior()
	{
		BehaviorFile behavior1 = new BehaviorFile("Disparar", Action.ABILITY , "El actor dispara al presionar Space.", false);
		actor.addBehavior(behavior1);
		assertTrue(actor.getBehaviors().contains(behavior1));
		assertEquals(1, actor.getBehaviors().size());
	}
	
	@Test
	public void testCreateActorWith2BehaviorsAndRemoveBehaviorIndex1()
	{
		BehaviorFile behavior1 = new BehaviorFile("Disparar", Action.ABILITY, "El actor dispara al presionar Space.", false);
		BehaviorFile behavior2 = new BehaviorFile("Mover", Action.ABILITY, "El actor se mueve con los direccionamientos", true);		
		actor.addBehavior(behavior1);
		actor.addBehavior(behavior2);

		actor.removeBehaviorIndex(1);
		
		assertFalse(actor.getBehaviors().contains(behavior2));
		assertEquals(1, actor.getBehaviors().size());
	}
	
	@Test
	public void testCreateActorWith2BehaviorsAndAskIfHasBehaviorNameTheReturnTrue()
	{
		BehaviorFile behavior1 = new BehaviorFile("Disparar", Action.ABILITY, "El actor dispara al presionar Space.", false);
		BehaviorFile behavior2 = new BehaviorFile("Mover", Action.ABILITY, "El actor se mueve con los direccionamientos", true);		
		actor.addBehavior(behavior1);
		actor.addBehavior(behavior2);
		
		assertTrue(actor.hasBehaviorName("Mover"));
	}
	
	@Test
	public void testCreateActorWith2BehaviorsAndAskIfHasBehaviorNameTheReturnFalse()
	{
		BehaviorFile behavior1 = new BehaviorFile("Disparar", Action.ABILITY, "El actor dispara al presionar Space.", false);
		BehaviorFile behavior2 = new BehaviorFile("Mover", Action.ABILITY, "El actor se mueve con los direccionamientos", true);		
		actor.addBehavior(behavior1);
		actor.addBehavior(behavior2);
		
		assertFalse(actor.hasBehaviorName("Rotar"));
	}
}
