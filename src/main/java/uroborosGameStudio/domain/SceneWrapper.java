package uroborosGameStudio.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.audio.Audio;
import org.team.uroboros.uroboros.engine.component.Actor;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.ui.TextureRenderer;
import org.team.uroboros.uroboros.engine.ui.resources.Animation;
import org.team.uroboros.uroboros.engine.ui.resources.Frame;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;
import org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet;
import org.team.uroboros.uroboros.engine.ui.resources.Texture;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class SceneWrapper extends GameObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<ActorWrapper> actors;
	private String pathAudio;
	private org.team.uroboros.uroboros.engine.audio.Audio audio;
	
	public SceneWrapper(String name)
	{
		this.name = name;
		this.ext = ".sce";
		this.actors = new ArrayList<ActorWrapper>();
		this.pathAudio = "";
	}
	
	public String getPathAudio()
	{
		return this.pathAudio;
	}

	public List<ActorWrapper> getActors()
	{
		return this.actors;
	}
	
	public void addActor(ActorWrapper actorWpp)	{
		this.actors.add(actorWpp);
		createActorUEngine(actorWpp);
	}

	public void createActorUEngine(ActorWrapper actorWpp) 
	{
		if(actorWpp.isAnimation())
		{
			System.out.println("Soy una animación");
			createAnimation(actorWpp);
		}
		else
		{
			createSimpleActor(actorWpp);
		}
	}
	/*
	 * PODRIA AGREGAR LA POSIBILIDAD DE EDITAR LA ANIMACION EN LA BAARA DE ARRIBA Y EL MENU DE EDICION.
	 * 		- Cantidad de sprites
	 * 		- Dimension de los sprites
	 * 		- Ratio.
	 */
	
	/*
	 * - Si es animacion: 
	 * 		- creo el spritesheet con los frames que me pasan por parametro
	 * 		- crear el sprite con el frame inicial
	 * 		- crear una textura Animation con los indices a utilizar para generar la animacion
	 * 		- setar textura por la creada (Animation)
	 * 		- ejecutar la animacion con el learn(new TextureRenderer());
	 */

	private void createSimpleActor(ActorWrapper actorWpp) {
		System.out.println("NO soy una animacion");
		Actor newActor = Game.createActor(actorWpp.getName());
		SpriteSheet spritesheet = new SpriteSheet(actorWpp.getPathImage(), new Frame(new Point(0,0), new Dimension(actorWpp.getRealWidth(), actorWpp.getRealHeight())));
		Sprite sprite = new Sprite(spritesheet, 0);
		newActor.setDimension(new Dimension(actorWpp.getWidth(), actorWpp.getHeight()));
		newActor.setTexture(sprite);
		newActor.learn(new TextureRenderer());
		newActor.translate(new Point(actorWpp.getX(), actorWpp.getY()));
	}

	private void createAnimation(ActorWrapper actorWpp) {
		Actor newActor = Game.createActor(actorWpp.getName());
		List<Frame> frames = new ArrayList<Frame>();
		List<Integer> indexs = new ArrayList<Integer>();
		Integer x = 0;
		Dimension dimension = new Dimension(actorWpp.getWidth(), actorWpp.getHeight());
		for (int i = 0; i < actorWpp.getSprites(); i++)
		{
			frames.add(new Frame(new Point(x,0), dimension));
			indexs.add(i);
			x+=actorWpp.getWidth();
		}
		Frame[] objects = new Frame[frames.size()]; 
		objects = frames.toArray(objects); 
		
		Integer[] indexAux = new Integer[indexs.size()]; 
		indexAux = indexs.toArray(indexAux); 
		
		SpriteSheet spritesheet = new SpriteSheet(actorWpp.getPathImage(), objects);
		Texture sprite = new Animation(spritesheet, actorWpp.getRatio(), indexAux); //lista de los indices que usa la animacion. El 2do numero mientras mas grande más lento
		newActor.setDimension(dimension);
		newActor.setTexture(sprite);
		newActor.learn(new TextureRenderer());
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
		this.name = newName;
	}

	public Boolean hasName(String name2) 
	{
		return name == name2;
	}

	public void save(String savedPath) throws IOException
	{
		String dir = savedPath + name + line();
		createFolder(dir);
		saveFile(dir);
		saveActors(dir);
	}

	private void saveActors(String savedPath)
	{
		this.actors.forEach(actor -> {
			try {
				actor.save(savedPath);
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

	public Boolean existActorName(String name) 
	{
		return this.actors.stream().anyMatch(actor -> actor.hasName(name));
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

	public Boolean existBehaviorName(String name) 
	{
		return this.actors.stream().anyMatch(actor -> actor.hasBehaviorName(name));
	}

	public void evalBehaviors(EcmaScriptEngine engine) 
	{
		this.actors.forEach(actor -> actor.evalBehaviors(engine));
	}

	public void actorsLearnAbilities(EcmaScriptEngine engine) 
	{
		this.actors.forEach(actor -> actor.learnAbilities(engine));
	}

	public void evalCollisions(EcmaScriptEngine engine) 
	{
		this.actors.forEach(actor -> actor.evalCollisions(engine));
	}

	@Override
	public void setPathAudio(String path) 
	{
		this.pathAudio = path;
	}

	public void playAudio() 
	{
		if(! pathAudio.isEmpty())
		{
			this.audio = new Audio(pathAudio);
			audio.loop();
		}
	}

	public void stopAudio() 
	{
		if(! pathAudio.isEmpty())
		{
			audio.stop();
		}
	}
}
