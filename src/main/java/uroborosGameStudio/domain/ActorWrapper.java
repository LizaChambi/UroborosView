package uroborosGameStudio.domain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.team.uroboros.uroboros.engine.Game;

public class ActorWrapper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String name;
	public String path;
	public Point point;
	public Dimension dimension;
	transient BufferedImage image;

	public ActorWrapper(String name, String path, Integer x, Integer y, Integer width, Integer height) 
	{
		this.name = name;
		this.path = path;
		readImage(path);
		this.point = new Point(x,y);
		this.dimension = new Dimension (width, height);
	}
	
	public double getRealWidth()
	{
		return this.image.getWidth();
	}
	
	public double getRealHeight()
	{
		return this.image.getHeight();
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	private void readImage(String path)
	{
		try 
		{
			this.image = ImageIO.read(new File("src/main/resources/" + path));
//			ImageIO.write(image, "png", new File("src/main/resources/" + path));
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}
	
	public int getX() 
	{
		return this.point.x;
	}

	public int getY() 
	{
		return this.point.y;
	}

	public int getWidth() 
	{
		return this.dimension.width;
	}

	public int getHeight() 
	{
		return this.dimension.height;
	}

	public void setName(String newName) 
	{
		Game.rename(Game.getActor(name), newName);
		this.name = newName;
	}
	
	@Override
	public String toString() 
	{
		return this.name;
	}
/*
	public String saveActor() {
		return name + ".act";
	}
*/
	
	public void saveFile(String savedPath) throws IOException
	{
		File file = new File(savedPath + getName() + ".act");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}
	
}
