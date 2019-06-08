package uroborosGameStudio.domain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.ui.TextureRenderer;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class SceneWrapper extends GameObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<ActorWrapper> actors;
	private String pathScene;
	private String oldName;
	
	public SceneWrapper(String name)
	{
		this.name = name;
		this.ext = ".sce";
		this.actors = new ArrayList<ActorWrapper>();
	}

	public List<ActorWrapper> getActors()
	{
		return this.actors;
	}
	
	public void addActor(ActorWrapper actorWpp)	{
		this.actors.add(actorWpp);
		actorWpp.setPathActor(pathScene + name + line());
		createActorUEngine(actorWpp);
		actorWpp.createFolder(actorWpp.getPathActor() + actorWpp.getName());
	}

	private void createActorUEngine(ActorWrapper actorWpp) 
	{
		Actor newActor = Game.createActor(actorWpp.getName());
		SpriteSheet spritesheet = new SpriteSheet(actorWpp.getPathImage(), new Frame(new Point(0,0), new Dimension(actorWpp.getRealWidth(), actorWpp.getRealHeight())));
		Sprite sprite = new Sprite(spritesheet, 0);
		newActor.setDimension(new Dimension(actorWpp.getWidth(), actorWpp.getHeight()));
		newActor.setTexture(sprite);
		newActor.learn(new TextureRenderer());
		newActor.translate(new Point(actorWpp.getX(), actorWpp.getY()));
	}
	

	public Integer cantActors() 
	{
		return this.actors.size();
	}

	public ActorWrapper getActorIn(Integer index) 
	{
		return this.actors.get(index);
	}

	@Override
	public String toString() 
	{
		return this.name;
	}

	@Override
	public void setName(String newName) {
		if(newName.equals("")) throw new NombreVacioException(this);
		Game.rename(Game.getScene(name), newName);
		this.oldName = name;
		this.name = newName;
		
		File oldfolder = new File(pathScene +oldName);
		File rename = new File(pathScene +name);
		oldfolder.renameTo(rename);
		
		deleteOldFiles(pathScene +name);
		
		actors.forEach(act -> act.setPathActor(pathScene + name + line()));
	}
	
	public String getPathScene() { return pathScene; }

	public void setPathScene(String pathScene) {
		this.pathScene = pathScene;
	}

	public Boolean hasName(String name2) 
	{
		return name == name2;
	}

	public void save(String savedPath) throws IOException	{
		saveFile(savedPath + name + line());
		saveActors(savedPath + name + line());
	}

	private void saveActors(String savedPath)
	{
		this.actors.forEach(act -> {
			try {
				act.save(savedPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Override
	public void setSceneUEngine() 
	{
		Game.setScene(this.name);
	}

	@Override
	public SceneWrapper selectedScene(MainWindowModel model) 
	{
		return this;
	}

	@Override
	public void setPosition(Integer x, Integer y) 
	{
	}

	@Override
	public Integer getX() {
		return 0;
	}

	@Override
	public Integer getY() {
		return 0;
	}

	public Boolean existActorName(String name) 
	{
		return this.actors.stream().anyMatch(actor -> actor.hasName(name));
	}

	@Override
	public String getPathImage() {
		return "";
	}

	@Override
	public Integer getWidth() {
		return 0;
	}

	@Override
	public Integer getHeight() {
		return 0;
	}

	@Override
	public void setPathImage(String path) 
	{
		// FALTA EL MÉTODO PARA CAMBIARLO EN U-ENGINE
	}

	@Override
	public void setDimensionImage(Integer width, Integer height) 
	{
		// FALTA EL MÉTODO PARA CAMBIARLO EN U-ENGINE
	}
	
	public void load() 
	{
		Game.createScene(this.name);
		Game.setScene(this.name);
		this.actors.forEach(actor -> actor.load());
	}
	
	public void deleteActor(String name) {
		this.actors.removeIf(actor -> actor.hasName(name));
		Game.removeActor(name);
	}

	@Override
	public List<BehaviorFile> getBehaviors() 
	{
		return new ArrayList<BehaviorFile>();
	}

	@Override
	public void addBehavior(BehaviorFile newBehavior) 
	{
	}

	public Boolean existBehaviorName(String name) 
	{
		return this.actors.stream().anyMatch(actor -> actor.hasBehaviorName(name));
	}

	@Override
	public void removeBehaviorIndex(int fileSelected) 
	{
	}

	@Override
	public String getBehaviorFileIndex(int index) 
	{
		return "";
	}

	@Override
	public void setBehaviorFileText(Integer file, String text) {}

	public void evalBehaviors(EcmaScriptEngine engine) 
	{
		this.actors.forEach(actor -> actor.evalBehaviors(engine));
	}

	public void actorsLearnAbilities(EcmaScriptEngine engine) 
	{
		this.actors.forEach(actor -> actor.learnAbilities(engine));
	}

	@Override
	public void setStatic() {}

	@Override
	public void setKinematic() {}

	@Override
	public void setDynatic() {}

	@Override
	public void setPhysicsBody(String body) {}

	@Override
	public String getBody() {
		return "";
	}

	@Override
	public Physics getPhysicsType() {
		return Physics.NONE;
	}

	@Override
	public List<Collider> getColliders() {
		return new ArrayList<Collider>();
	}

	@Override
	public void addCollision(Collider collition) {}

	@Override
	public String getCollitionCode(int index) {
		return "";
	}

	@Override
	public void setCollitionText(Integer index, String text) {}

	@Override
	public void removeCollisionIndex(int index) {}

	public void evalCollisions(EcmaScriptEngine engine) 
	{
		this.actors.forEach(actor -> actor.evalCollisions(engine));
	}
	
}
