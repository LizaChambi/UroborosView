package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class GameObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	String name = "";
	String ext = "";

	public String getName()
	{
		return this.name;
	}
	
	public String getExt()
	{
		return this.ext;
	}
	
	protected String getSavedPath() {
		return getPathRoot() + System.getProperty("file.separator");
	}

	public abstract String getPathRoot();

	public abstract void setName(String name);

	public void saveFile(String savedPath) throws IOException
	{
		File file = new File(savedPath + getName() + getExt());
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}
	
	public void deleteFile(String savedPath) {
		try {
			Files.delete(Paths.get(savedPath + getName() + getExt()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
