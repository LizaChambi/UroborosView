package uroborosGameStudio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.Collider;

public class ColliderTest 
{
	
	Collider collider;
	
	@Before
	public void setUp()	
	{
		this.collider = new Collider("Destruirse", "Se destruye al ser impactado con un bala.");
	}
	
	@Test
	public void testCreateNewColliderWithNameAndDescription() 
	{	
		assertEquals("Destruirse", collider.getName());
		assertEquals("Se destruye al ser impactado con un bala.", collider.getDescription());
	}
	
	@Test
	public void testCreateNewColliderAndAddCode() 
	{	
		collider.setCode("function");
		assertEquals("function", collider.getCode());
	}

}
