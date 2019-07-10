package uroborosGameStudio.domain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Game;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class UGSProject extends GameObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String projectName;
	private String pathRoot;
	private List<SceneWrapper> scenes;
	private String pathBehaviors;
	private String pathAbilities;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.name = gameName;
		this.ext = ".ugs";
		this.projectName = projectName;
		this.pathRoot = System.getProperty("user.home") + line() + this.projectName;
		this.pathBehaviors = this.pathRoot + line() + "Global Behaviors";
		this.pathAbilities = this.pathRoot + line() + "Global Abilities";
		createProjectDir();
		this.scenes = new ArrayList<SceneWrapper>();
		createMainScene();
	}
	
	public String getPathBehaviors()
	{
		return this.pathBehaviors;
	}
	
	public String getPathAbilities()
	{
		return this.pathAbilities;
	}

	private void createMainScene() 
	{
		this.addScene(new SceneWrapper("Escena0"));
	}

	public String getPathRoot() {
		return this.pathRoot;
	}

	public List<SceneWrapper> getScenes() {
		return this.scenes;
	}

	public void createProjectDir() 
	{
		createFolder(pathRoot);
		createFolder(pathBehaviors);
		createFolder(pathAbilities);
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void addScene(SceneWrapper newScene) {
		this.scenes.add(newScene);
		Game.createScene(newScene.getName());
		Game.setScene(newScene.getName());
	}

	@Override
	public String toString() 
	{
		return this.name;
	}

	@Override
	public void setName(String newTitle) {
		if(newTitle.equals("")) throw new NombreVacioException(this);
		this.name = newTitle;
	}

	public SceneWrapper searchScene(String name) 
	{
		return this.scenes.stream().filter(scene -> scene.getName().equals(name)).findFirst().get();
	}
	
	public void saveProject() throws IOException
	{
		deleteOldFiles(getPathRoot());
		saveFile(getSavedPath());
		saveScenes();
	}
	
	// este metodo debe ser privado
	public void deleteOldFiles(String path) {
		File file = new File(path); 
		File[] files = file.listFiles();
		if(file.exists()) 
		{
			for (int x=0;x<files.length;x++) 
			{
				deleteFiles(files[x]);
				deleteFolders(files[x]);
			}
			
		} 
		else { System.out.println("No existe el directorio"); }
	}

	private void deleteFiles(File archivo) 
	{
		if(archivo.isDirectory())
		{
			deleteOldFiles(archivo.getPath());
		}
		else
		{
			archivo.delete(); 
		}
	}
	
	private void deleteFolders(File archivo) 
	{
		if(archivo.isDirectory() && ! isGameFolder(archivo.getPath()) )
		{
			archivo.delete(); 
		}
	}
	
	private Boolean isGameFolder(String path)
	{
		return isEqualPath(path, this.pathAbilities) || isEqualPath(path, this.pathBehaviors);
	}

	private boolean isEqualPath(String path1, String path2) 
	{
		return path1.equals(path2);
	}
	
	public String getSavedPath() 
	{
		return getPathRoot() + line();
	}

	private void saveScenes() 
	{
		this.scenes.forEach(scene -> {
			try 
			{
				scene.save(getSavedPath());
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Override
	public void setSceneUEngine() {}

	@Override
	public SceneWrapper selectedScene(MainWindowModel model) 
	{
		return null;
	}

	public Boolean existActorName(String name) 
	{
		return this.scenes.stream().anyMatch(scene -> scene.existActorName(name));
	}
	
	public boolean existSceneName(String name) {
		return this.scenes.stream().anyMatch(scene -> scene.hasName(name));
	}
	
	public void loadProject() 
	{
		this.scenes.forEach(scene -> scene.load());
	}

	public SceneWrapper deleteActor(ActorWrapper actor) 
	{
		SceneWrapper scene = searchScene(Game.getSceneWithActor(actor.getName()).getName());
		scene.deleteActor(actor.getName());
		return scene;
	}
	
	public void deleteScene(SceneWrapper scene) 
	{	
		this.scenes.removeIf(sce -> sce.hasName(scene.getName()));
		Game.removeScene(scene.getName());
	}

	public boolean existBehaviorName(String name) 
	{
		return this.scenes.stream().anyMatch(scene -> scene.existBehaviorName(name));
	}

	/*
	public void evalBehaviors(EcmaScriptEngine engine) 
	{
		this.searchScene(Game.getCurrentScene().getName()).evalBehaviors(engine);
	}
	*/
	
	// METODO EVAL DE TODAS LAS ESCENAS
	public void evalAllBehaviors(EcmaScriptEngine engine) 
	{
		this.scenes.forEach(scene -> scene.evalBehaviors(engine));
	}

	/*
	public void actorsLearnAbilities(EcmaScriptEngine engine) 
	{
		this.searchScene(Game.getCurrentScene().getName()).actorsLearnAbilities(engine);
	}
	*/
	
	// METODO EVAL DE TODAS LAS HABILIDADES
	public void actorsLearnAllAbilities(EcmaScriptEngine engine) 
	{
		this.scenes.forEach(scene -> scene.actorsLearnAbilities(engine));
	}

	/*
	public void evalCollisions(EcmaScriptEngine engine) 
	{
		this.searchScene(Game.getCurrentScene().getName()).evalCollisions(engine);
	}
	*/
	
	// METODO EVAL DE TODAS LAS COLISIONES
	public void evalAllCollisions(EcmaScriptEngine engine) 
	{
		this.scenes.forEach(scene -> scene.evalCollisions(engine));
	}

	@Override
	public void setPathAudio(String path) {}

	@Override
	public String getPathAudio() {
		return "";
	}
}
