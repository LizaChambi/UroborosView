package uroborosGameStudio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.Action;
import uroborosGameStudio.domain.BehaviorFile;

public class BehaviorFileTest 
{
	BehaviorFile behavior;
	
	@Before
	public void setUp()	
	{
		this.behavior = new BehaviorFile("Movimiento", Action.ABILITY, "Descripción de la acción.", false);
	}
	
	@Test
	public void testCreateNewBehaviorFileWithNameAndDescription() 
	{	
		assertEquals("Movimiento", behavior.getName());
		assertEquals(Action.ABILITY, behavior.getType());
		assertEquals("Descripción de la acción.", behavior.getDescription());
		assertFalse(behavior.getIsGlobal());
	}
	
	@Test
	public void testCreateNewBehaviorFileWithNameAndAskIfHasNameThenReturnTrue() 
	{	
		assertTrue(behavior.hasName("Movimiento"));
	}
	
	@Test
	public void testCreateNewBehaviorFileWithNameAndAskIfHasNameThenReturnFalse() 
	{	
		behavior.setName("Disparar");
		assertFalse(behavior.hasName("Movimiento"));
	}
	
}
