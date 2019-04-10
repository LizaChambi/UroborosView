package uroborosGameStudio.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UGSProyect 
{
	private String gameTitle;
	private String proyectName;
	private String path;
	private List<Scene> scenes;
	
	public UGSProyect(String proyectName, String gameName) 
	{
		this.gameTitle = gameName;
		this.proyectName = proyectName;
		createProyectDir();
		this.scenes = new ArrayList<Scene>();
		this.getScenes().add(new Scene("Scene"));
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	public List<Scene> getScenes()
	{
		return this.scenes;
	}	

	public void createProyectDir()
	{
		String dp = System.getProperty("user.home");
		String line = System.getProperty("file.separator");
		File dir = new File(dp + line + this.proyectName);
		createDir(dir);
	}
	
	public void createDir(File dir)
	{
		this.path = dir.getPath();
		dir.mkdir();
	}

	public String getProyectName() 
	{
		return this.proyectName;
	}
	
	public String getGameTitle()
	{
		return this.gameTitle;
	}
}
