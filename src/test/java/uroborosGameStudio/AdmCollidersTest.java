package uroborosGameStudio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.AdmColliders;
import uroborosGameStudio.domain.Collider;

public class AdmCollidersTest 
{
	Collider collider1;
	Collider collider2;
	AdmColliders collisions;
	
	@Before
	public void setUp()	
	{
		this.collider1 = new Collider("Destruise", "Se destruye al chocar con algo.");
		this.collider2 = new Collider("Animación", "Se visualiza animación de explosión.");
		this.collisions = new AdmColliders();
	}
	
	@Test
	public void testCreateNewAdmCollidersEmpty() 
	{	
		assertTrue(collisions.getColliders().isEmpty());
	}
	
	@Test
	public void testCreateNewAdmCollidersWith2Collider() 
	{	
		collisions.addCollider(collider1);
		collisions.addCollider(collider2);
		
		assertEquals(2, collisions.getColliders().size());
		assertTrue(collisions.getColliders().contains(collider1));
		assertTrue(collisions.getColliders().contains(collider2));
	}
	
	@Test
	public void testCreateNewAdmCollidersWith2ColliderAndRemoveColliderIndex1() 
	{	
		collisions.addCollider(collider1);
		collisions.addCollider(collider2);
		
		assertTrue(collisions.getColliders().contains(collider2));
		collisions.removeColliderIndex(1);
		assertFalse(collisions.getColliders().contains(collider2));
		assertTrue(collisions.getColliders().contains(collider1));
		assertEquals(1, collisions.getColliders().size());
	}
}
