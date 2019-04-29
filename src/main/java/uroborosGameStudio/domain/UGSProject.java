package uroborosGameStudio.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Game;


public class UGSProject extends GameObject
{
	private String projectName;
	private String path;
	private List<SceneWrapper> scenes;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.name = gameName;
		this.projectName = projectName;
		createProjectDir();
		this.scenes = new ArrayList<SceneWrapper>();
		createMainScene();
	}

	private void createMainScene() 
	{
		this.scenes.add(new SceneWrapper("Escena0"));
		Game.createScene("Escena0");
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	public List<SceneWrapper> getScenes()
	{
		return this.scenes;
	}	

	public void createProjectDir()
	{
		String dp = System.getProperty("user.home");
		String line = System.getProperty("file.separator");
		File dir = new File(dp + line + this.projectName);
		createDir(dir);
	}
	
	public void createDir(File dir)
	{
		this.path = dir.getPath();
		dir.mkdir();
	}

	public String getProjectName() 
	{
		return this.projectName;
	}

	public void addScene(SceneWrapper newScene) 
	{
		this.scenes.add(newScene);
		Game.createScene(newScene.getName());
	}

	@Override
	public String toString() 
	{
		return this.name;
	}

	@Override
	public void setName(String newTitle) 
	{
		this.name = newTitle;
	}

	public SceneWrapper searchScene(String name) 
	{
		return this.scenes.stream().filter(scene -> scene.getName().equals(name)).findFirst().get();
	}
	
}
