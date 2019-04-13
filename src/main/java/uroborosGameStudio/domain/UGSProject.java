package uroborosGameStudio.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UGSProject 
{
	private String gameTitle;
	private String projectName;
	private String path;
	private List<Scene> scenes;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.gameTitle = gameName;
		this.projectName = projectName;
		createProjectDir();
		this.scenes = new ArrayList<Scene>();
		this.getScenes().add(new Scene("Escena0"));
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	public List<Scene> getScenes()
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
	
	public String getGameTitle()
	{
		return this.gameTitle;
	}

	public void addScene(Scene newScene) 
	{
		this.scenes.add(newScene);
	}
}
