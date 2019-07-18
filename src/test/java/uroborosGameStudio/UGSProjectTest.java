package uroborosGameStudio;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;


public class UGSProjectTest {
	
	SceneWrapper scene;
	
	UGSProject project;
	
	@Before
	public void setUp()	{
		this.scene = new SceneWrapper("Main Scene");
		
		project = new UGSProject("DirectoryName","GameTitle");
	}
	
	@Test
	public void testCreateNewUGSProjectWithNameAndGameTitle() {	
		File dir = new File(project.getPathRoot());
		
		assertEquals("DirectoryName", project.getProjectName());
		assertEquals("GameTitle", project.getName());
		assertTrue(dir.exists());
		assertEquals("Escena0", project.searchScene("Escena0").getName());
		assertTrue(1 == project.getScenes().size());
	}
	
	@Test
	public void testCreateProjectDir() {
		project.createProjectDir();
		
		String dp = System.getProperty("user.home");
		String line = System.getProperty("file.separator");
		
		assertEquals(dp + line + "DirectoryName", project.getPathRoot());
		assertEquals(dp + line + project.getProjectName() + line + "Global Behaviors", project.getPathBehaviors());
		assertEquals(dp + line + project.getProjectName() + line + "Global Abilities", project.getPathAbilities());
	}
	
	@Test
	public void testAddScene() {
		String nameScene = scene.getName();
		project.addScene(scene);
		
		assertEquals(scene, project.searchScene(nameScene));
		assertTrue(2 == project.getScenes().size());
	}
	
	@Test
	public void testSetNewName() {
		project.setName("Star Wars");
		
		assertEquals("Star Wars", project.getName());
	}
	
	@Test (expected = RuntimeException.class)
	public void testSetNameEmpty() {
		project.setName("");
		
		assertEquals("akjsdqouee", project.getName());
	}
	
	@Test
	public void testSearchScene() {
		project.addScene(scene);
		SceneWrapper found = project.searchScene(scene.getName());
		
		assertEquals(scene, found);
		assertTrue(scene.getName().equals(found.getName()));
	}
	
}
