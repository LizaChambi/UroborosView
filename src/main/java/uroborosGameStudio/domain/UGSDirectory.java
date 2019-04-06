package uroborosGameStudio.domain;

import java.io.File;

public class UGSDirectory 
{
	private String path;
	private String nameProyect;
	
	public UGSDirectory (String name)
	{
		this.nameProyect = name;
	}
	
	public String getNameProyect()
	{
		return this.nameProyect;
	}
	
	public void createDir(File dir)
	{
		if (dir.mkdir())
		{
			this.path = dir.getPath();
			System.out.println("Se ha creado el proyecto " + this.nameProyect + " con éxito");
		}
		else
		{
			System.out.println("No se pudo crear el proyecto.");
		}
	}
	
	public void createProyectDir(String path)
	{
		String line = System.getProperty("file.separator");
		File dir = new File(path + line + this.nameProyect);
		createDir(dir);
	}
	
	public void createProyectDirDefaults()
	{
		String dp = System.getProperty("user.home");
		String line = System.getProperty("file.separator");
		File dir = new File(dp + line + this.nameProyect);
		createDir(dir);
	}
	
	public static void main(String[] args) 
	{
		UGSDirectory proyect = new UGSDirectory ("Nueva Carpeta");
		proyect.createProyectDir("/home/chambi_liza/Documentos");
		proyect.createProyectDirDefaults();
	}
}
