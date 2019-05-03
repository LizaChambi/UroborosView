package uroborosGameStudio.domain;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.team.uroboros.uroboros.engine.Game;

public class ActorWrapper extends GameObject  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String path;
	public Point point;
	public Dimension dimension;
	transient BufferedImage image;

	public ActorWrapper(String name, String path, Integer x, Integer y, Integer width, Integer height) {
		this.name = name;
		this.ext = ".act";
		this.path = path;
		readImage(path);
		this.point = new Point(x, y);
		this.dimension = new Dimension(width, height);
	}

	public double getRealWidth() {
		return this.image.getWidth();
	}

	public double getRealHeight() {
		return this.image.getHeight();
	}

	public String getPath() {
		return this.path;
	}

	private void readImage(String path) {
		try {
			this.image = ImageIO.read(new File("src/main/resources/" + path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public int getX() {
		return this.point.x;
	}

	public int getY() {
		return this.point.y;
	}

	public int getWidth() {
		return this.dimension.width;
	}

	public int getHeight() {
		return this.dimension.height;
	}

	@Override
	public void setName(String newName) {
		// deleteFile(getSavedPath());
		Game.rename(Game.getActor(name), newName);
		this.name = newName;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
