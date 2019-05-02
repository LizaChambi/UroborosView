package uroborosGameStudio;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.UGSProject;


public class UGSProjectTest 
{
	UGSProject project;
	
	@Before
	public void setUp()
	{
		project = new UGSProject("DirectoryName","GameTitle");
	}
	
	@Test
	public void testCreateNewUGSProyectWithNameAndGameTitle()
	{	
		File dir = new File(project.getPathRoot());
		
		assertEquals("DirectoryName", project.getProjectName());
		assertEquals("GameTitle", project.getName());
		assertTrue(dir.exists());
	}
	
}
