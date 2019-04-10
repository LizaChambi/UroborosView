package uroborosGameStudio.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UGSProyect 
{
	private String title;
	private String proyectName;
	private String path;
	private List<Scene> scenes;
	
	public UGSProyect(String proyectName, String gameName) 
	{
		this.title = gameName;
		this.proyectName = proyectName;
		createProyectDir();
		this.scenes = new ArrayList<Scene>();
		this.scenes.add(new Scene("Scene1"));
		this.scenes.add(new Scene("Scene2"));
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
		if (dir.mkdir())
		{
			this.path = dir.getPath();
			System.out.println("Se ha creado el proyecto " + this.proyectName + " con éxito");
		}
		else
		{
			System.out.println("No se pudo crear el proyecto.");
		}
	}

	public String getProyectName() 
	{
		return this.proyectName;
	}
	
	public String getGameTitle()
	{
		return this.title;
	}
}
