package uroborosGameStudio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.Action;
import uroborosGameStudio.domain.AdmBehaviors;
import uroborosGameStudio.domain.BehaviorFile;

public class AdmBehaviorsTest 
{
	BehaviorFile behavior1;
	BehaviorFile behavior2;
	AdmBehaviors behaviors;
	
	@Before
	public void setUp()	
	{
		this.behavior1 = new BehaviorFile("Movimiento", Action.BEHAVIOR, "Descripción de la acción de movimiento.", true);
		this.behavior2 = new BehaviorFile("Disparar", Action.ABILITY, "Descripción de la acción de disparar.", false);
		this.behaviors = new AdmBehaviors();
	}
	
	@Test
	public void testCreateNewAdmBehaviorEmpty() 
	{	
		assertTrue(behaviors.getBehaviors().isEmpty());
	}
	
	@Test
	public void testCreateNewAdmBehaviorWith2Behaviors() 
	{	
		behaviors.addBehavior(behavior1);
		behaviors.addBehavior(behavior2);
		
		assertEquals(2, behaviors.getBehaviors().size());
		assertTrue(behaviors.getBehaviors().contains(behavior1));
		assertTrue(behaviors.getBehaviors().contains(behavior2));
	}
	
	@Test
	public void testCreateNewAdmBehaviorWith2BehaviorsAndRemove1() 
	{	
		behaviors.addBehavior(behavior1);
		behaviors.addBehavior(behavior2);
		
		assertTrue(behaviors.getBehaviors().contains(behavior1));
		behaviors.removeBehavior(behavior1);
		assertFalse(behaviors.getBehaviors().contains(behavior1));
		assertTrue(behaviors.getBehaviors().contains(behavior2));
		assertEquals(1, behaviors.getBehaviors().size());
	}
	
	@Test
	public void testCreateNewAdmBehaviorWith2BehaviorsAndRemoveBehaviorIndex1() 
	{	
		behaviors.addBehavior(behavior1);
		behaviors.addBehavior(behavior2);
		
		assertTrue(behaviors.getBehaviors().contains(behavior2));
		behaviors.removeBehaviorIndex(1);;
		assertTrue(behaviors.getBehaviors().contains(behavior1));
		assertFalse(behaviors.getBehaviors().contains(behavior2));
		assertEquals(1, behaviors.getBehaviors().size());
	}
	
	@Test
	public void testCreateNewAdmBehaviorWith2BehaviorsAndAskHasBehaviorNameThenReturnTrue() 
	{	
		behaviors.addBehavior(behavior1);
		behaviors.addBehavior(behavior2);
		
		assertTrue(behaviors.hasBehaviorName("Disparar"));
	}
	
	@Test
	public void testCreateNewAdmBehaviorWith2BehaviorsAndAskHasBehaviorNameThenReturnFalse() 
	{	
		behaviors.addBehavior(behavior1);
		behaviors.addBehavior(behavior2);
		
		assertFalse(behaviors.hasBehaviorName("Girar"));
	}
	
}
