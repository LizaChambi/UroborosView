package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import uroborosGameStudio.domain.appModel.MainWindowModel;

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
	
	public abstract void setName(String name);

	public void saveFile(String savedPath) throws IOException
	{
		File file = new File(savedPath + getName() + getExt());
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}

	public abstract void setSceneUEngine();

	public abstract SceneWrapper selectedScene(MainWindowModel model);

	public abstract void setPosition(int x, int y);

	public abstract Integer getX();

	public abstract Integer getY();


}
