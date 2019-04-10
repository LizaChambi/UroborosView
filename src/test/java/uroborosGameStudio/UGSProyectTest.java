package uroborosGameStudio;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.UGSProyect;


public class UGSProyectTest 
{
	UGSProyect proyect;
	
	@Before
	public void setUp()
	{
		proyect = new UGSProyect("DirectoryName","GameTitle");
	}
	
	@Test
	public void testCreateNewUGSProyectWithNameAndGameTitle()
	{	
		File dir = new File(proyect.getPath());
		
		assertEquals("DirectoryName", proyect.getProyectName());
		assertEquals("GameTitle", proyect.getGameTitle());
		assumeTrue(dir.exists());
	}
	
}
