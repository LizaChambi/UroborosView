package uroborosGameStudio.domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Ability;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.component.Scene;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.input.Key;
import org.team.uroboros.uroboros.engine.ui.Graphics;
import org.team.uroboros.uroboros.engine.ui.TextureRenderer;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;

import com.team.uroboros.jtypescript.engine.TypeScriptEngine;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class ActorWrapper extends GameObject  implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String path;
	private java.awt.Point point;
	private java.awt.Dimension dimension;
	private transient BufferedImage image;
	private double frames;
	private AdmBehaviors behaviors;

	public ActorWrapper(String name, String path, Integer x, Integer y, Integer width, Integer height) {
		this.name = name;
		this.ext = ".act";
		this.path = path;
		readImage(path);
		this.point = new java.awt.Point(x, y);
		this.dimension = new java.awt.Dimension(width, height);
		this.frames = 1;
		this.behaviors = new AdmBehaviors();
	}

	public ActorWrapper() {}

	public List<BehaviorFile> getBehaviors()
	{
		return this.behaviors.getBehaviors();
	}
	
	public double getRealWidth() {
		return this.image.getWidth();
	}
	
	public java.awt.Point getPosition()
	{
		return this.point;
	}
	
	public java.awt.Dimension getDimension()
	{
		return this.dimension;
	}

	public double getRealHeight() {
		return this.image.getHeight();
	}

	private void readImage(String path) {
		try {
			this.image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BufferedImage getImage() {
		return this.image;
	}

	@Override
	public Integer getX() {
		return this.point.x;
	}

	@Override
	public Integer getY() {
		return this.point.y;
	}
	
	@Override
	public Integer getWidth() {
		return this.dimension.width;
	}

	@Override
	public Integer getHeight() {
		return this.dimension.height;
	}

	@Override
	public void setName(String newName) {
		if(newName.equals("")) throw new NombreVacioException(this);
		Game.rename(Game.getActor(name), newName);
		this.name = newName;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public void setSceneUEngine() 
	{
		Scene selectedScene = Game.getSceneWithActor(this.name);
		Game.setScene(selectedScene);
	}

	@Override
	public SceneWrapper selectedScene(MainWindowModel model) 
	{
		return model.searchScene(Game.getSceneWithActor(this.getName()).getName());
	}

	@Override
	public void setPosition(Integer x, Integer y) 
	{
		this.point = new java.awt.Point(x,y);
		Game.getActor(name).translateTo(x,y);
	}

	public Boolean hasName(String name) 
	{
		return getName().equals(name);
	}

	@Override
	public String getPathImage() {
		return this.path;
	}

	@Override
	public void setPathImage(String path) 
	{
		// Pasar propiedades por la interface EN CASO de necesitar frames: 
		this.path = path;
		readImage(path);
		setPathImageUEngine(path);
	}

	private void setPathImageUEngine(String path) 
	{
		SpriteSheet spritesheet = new SpriteSheet(path, new Frame(Point.ORIGIN, new Dimension(this.getRealWidth(), this.getRealHeight())) );
		Sprite sprite = new Sprite(spritesheet, 0);
		Game.getActor(name).setTexture(sprite);
	}

	@Override
	public void setDimensionImage(Integer width, Integer height) 
	{
		this.dimension = new java.awt.Dimension(width, height);
		Game.getActor(name).setDimension(width, height);
	}
	
	public void load() 
	{
		readImage(this.path);
		loadActorUEngine();
	}

	private void loadActorUEngine() 
	{
		Actor actorLoaded = Game.createActor(this.name);
		SpriteSheet spritesheet = new SpriteSheet(this.path, new Frame(Point.ORIGIN, new Dimension(this.getRealWidth(), this.getRealHeight())) );
		Sprite sprite= new Sprite(spritesheet, 0);
		actorLoaded.setDimension(new Dimension(this.getWidth(), this.getHeight()));
		actorLoaded.setTexture(sprite);
		actorLoaded.learn(new TextureRenderer());
		actorLoaded.translate(new Point(this.getX(), this.getY()));
		// HABILIDAD DE PRUEBA
		actorLoaded.learn(new Ability() 
		{	
			Actor actor;
			
			@Override
			public void onStart(Actor actor) 
			{
				this.actor =actor;
			}
			
			@Override
			public void onUpdate(Double deltaTime) 
			{
				if(Key.UP.isPressed()) 
				{
					this.actor.translate(0, 3);
				}
				if(Key.RIGHT.isPressed()) 
				{
					this.actor.translate(3, 0);
				}
				if(Key.DOWN.isPressed()) 
				{
					this.actor.translate(0, -3);
				}
				if(Key.LEFT.isPressed()) 
				{
					this.actor.translate(-3, 0);
				}
			}
			
			@Override
			public void onRender(Graphics graphics) { }

		});
	}

	@Override
	public void addBehavior(BehaviorFile newBehavior) 
	{
		this.behaviors.addBehavior(newBehavior);
	}

	public Boolean hasBehaviorName(String name) 
	{
		return this.behaviors.hasBehaviorName(name);
	}

	@Override
	public void removeBehaviorIndex(int index) 
	{
		this.behaviors.removeBehaviorIndex(index);
	}

	@Override
	public String getBehaviorFileIndex(int index) 
	{
		return this.behaviors.getBehaviorFile(index);
	}

	@Override
	public void setBehaviorFileText(Integer file, String text) 
	{
		this.behaviors.setCodeFile(file, text);
	}

	public void evalBehaviors(TypeScriptEngine engine) 
	{
		this.behaviors.evalBehaviorFiles(engine);
	}	
}
