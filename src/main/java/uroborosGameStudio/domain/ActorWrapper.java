package uroborosGameStudio.domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.component.Scene;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.physics.material.BoxMaterial;
import org.team.uroboros.uroboros.engine.physics.material.PhysicsMaterial;
import org.team.uroboros.uroboros.engine.physics.material.SphereMaterial;
import org.team.uroboros.uroboros.engine.ui.TextureRenderer;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class ActorWrapper extends GameObject  implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String pathImage;
	private java.awt.Point point;
	private java.awt.Dimension dimension;
	private transient BufferedImage image;
	private double frames;
	private AdmBehaviors behaviors;
	private AdmColliders collisions;
	private String body;
	private Physics physicType;
	private Integer ratio;

	/*
	public ActorWrapper(String name, String path, Integer x, Integer y, Integer width, Integer height) {
		this.name = name;
		this.ext = ".act";
		this.pathImage = path;
		readImage(path);
		this.point = new java.awt.Point(x, y);
		this.dimension = new java.awt.Dimension(width, height);
		this.frames = 1;
		this.behaviors = new AdmBehaviors();
		this.collisions = new AdmColliders();
		this.body = "";
		this.physicType = Physics.NONE;
	}
	*/

	public ActorWrapper(String name, String path, int x, int y) 
	{
		this.name = name;
		this.pathImage = path;
		readImage(path);
		this.point = new java.awt.Point(x, y);
		this.dimension = new java.awt.Dimension(this.getRealWidth(), this.getRealHeight());
		this.frames = 1;
		this.ext = ".act";
		this.behaviors = new AdmBehaviors();
		this.collisions = new AdmColliders();
		this.body = "";
		this.physicType = Physics.NONE;
		this.ratio = 0;
	}

	public ActorWrapper(String name, String path, int x, int y, int width, int height, int sprites, int ratio) 
	{
		this.name = name;
		this.ext = ".act";
		this.pathImage = path;
		readImage(path);
		this.point = new java.awt.Point(x, y);
		this.dimension = new java.awt.Dimension(width, height);
		this.frames = sprites;
		this.behaviors = new AdmBehaviors();
		this.collisions = new AdmColliders();
		this.body = "";
		this.physicType = Physics.NONE;
		this.ratio = ratio;
	}

	public ActorWrapper() {
		// TODO Auto-generated constructor stub
	}

	public List<BehaviorFile> getBehaviors()
	{
		return this.behaviors.getBehaviors();
	}
	
	public int getRealWidth() {
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

	public int getRealHeight() {
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
		return this.pathImage;
	}

	@Override
	public void setPathImage(String path) 
	{
		// Pasar propiedades por la interface EN CASO de necesitar frames: 
		this.pathImage = path;
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
		readImage(this.pathImage);
		loadActorUEngine();
	}

	private void loadActorUEngine() 
	{	// CAMBIAR EN EL CASO DE SER UNA ANIMACIÓN O UNAIMAGEN COMUN
		Actor actorLoaded = Game.createActor(this.name);
		
		SpriteSheet spritesheet = new SpriteSheet(this.pathImage, new Frame(Point.ORIGIN, new Dimension(this.getRealWidth(), this.getRealHeight())) );
		Sprite sprite= new Sprite(spritesheet, 0);
		actorLoaded.setDimension(new Dimension(this.getWidth(), this.getHeight()));
		actorLoaded.setTexture(sprite);
		actorLoaded.learn(new TextureRenderer());
		System.out.println("Punto a recrear: " + this.getX() + " , " + this.getY());
		actorLoaded.translate(new Point(this.getX(), this.getY()));
		
		this.setPhysicsBodyUEngine(this.body);
		this.setPhysicsTypeUEngine(this.physicType);
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

	public void evalBehaviors(EcmaScriptEngine engine) 
	{
		this.behaviors.evalBehaviorFiles(engine);
	}

	public void learnAbilities(EcmaScriptEngine engine) 
	{
		Actor actor = Game.getActor(name);
		this.behaviors.getBehaviors().forEach(behavior -> behavior.learnAbility(actor, engine));
	}

	public void save(String savedPath) throws IOException 
	{
		String dir = savedPath + name + line();
		createFolder(dir);
		saveFile(dir);
		this.behaviors.saveBehaviors(dir);
	}

	@Override
	public void setPhysicsType(Physics type)
	{
		this.physicType = type;
		this.setPhysicsTypeUEngine(type);
	}

	private void setPhysicsTypeUEngine(Physics type) 
	{
		Actor actor = Game.getActor(this.name);
		if (type.equals(Physics.DYNAMIC))
		{
			actor.setAsDynamic();
		}
		if (type.equals(Physics.KINEMATIC))
		{
			actor.setAsKinematic();
		}
		if (type.equals(Physics.STATIC))
		{
			actor.setAsStatic();
		}
	}

	@Override
	public void setPhysicsBody(String body) 
	{
		this.body = body;
		setPhysicsBodyUEngine(body);
	}

	private void setPhysicsBodyUEngine(String body) 
	{
		Actor actor = Game.getActor(this.name);
		if(body.equals("Círculo"))
		{
			PhysicsMaterial cuerpo = new SphereMaterial(this.getDimension().getWidth() * 0.5, PhysicsMaterial.DEFAULT_FRICTION, PhysicsMaterial.DEFAULT_RESTITUTION, PhysicsMaterial.DEFAULT_DENSITY);
			actor.addPhysicsMaterial(cuerpo);
		}
		if (body.equals("Rectángulo"))
		{
			PhysicsMaterial cuerpo = new BoxMaterial(this.getWidth(), this.getHeight(), PhysicsMaterial.DEFAULT_FRICTION, PhysicsMaterial.DEFAULT_RESTITUTION, PhysicsMaterial.DEFAULT_DENSITY);
			actor.addPhysicsMaterial(cuerpo);
		}
	}

	@Override
	public String getBody() 
	{
		return this.body;
	}

	@Override
	public Physics getPhysicsType() 
	{
		return this.physicType;
	}

	@Override
	public List<Collider> getColliders() 
	{
		return this.collisions.getColliders();
	}

	@Override
	public void addCollision(Collider collition) 
	{
		this.collisions.addCollider(collition);
	}

	@Override
	public String getCollitionCode(int index) {
		return this.collisions.getCollitionIndex(index).getCode();
	}

	@Override
	public void setCollitionText(Integer index, String text) 
	{
		this.collisions.getCollitionIndex(index).setCode(text);
	}

	@Override
	public void removeCollisionIndex(int index) 
	{
		this.collisions.removeColliderIndex(index);
	}

	public void evalCollisions(EcmaScriptEngine engine) 
	{
		this.collisions.evalColliders(engine, this.name);
	}

	@Override
	public void setPathAudio(String path) {}

	@Override
	public String getPathAudio() {
		return "";
	}

	public boolean isAnimation() 
	{
		return this.frames>1;
	}

	public double getSprites() 
	{
		return this.frames;
	}

	public Integer getRatio() 
	{
		return this.ratio;
	}
}
