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
	/*
	public void deleteFolderSubDirectories(String nameScene) {
		Path dir = Paths.get(this.pathRoot + line()+ nameScene);
		try {
			Files.walk(dir, 2)
		      .sorted(Comparator.reverseOrder())
		      .map(Path::toFile)
		      .forEach(File::delete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	
	public void saveProject() throws IOException
	{
		deleteOldFiles(getPathRoot());
		saveFile(getSavedPath());
		saveScenes();
	}
	
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
		if(archivo.isDirectory())
		{
			archivo.delete(); 
		}
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

	@Override
	public void setPosition(Integer x, Integer y) {}

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
		return this.scenes.stream().anyMatch(scene -> scene.existActorName(name));
	}

	@Override
	public String getPathImage() 
	{
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
	public void setPathImage(String path) {}

	@Override
	public void setDimensionImage(Integer width, Integer heigth) {}
	
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

	@Override
	public List<BehaviorFile> getBehaviors() 
	{
		return new ArrayList<BehaviorFile>();
	}

	@Override
	public void addBehavior(BehaviorFile newBehavior) {}

	public boolean existBehaviorName(String name) 
	{
		return this.scenes.stream().anyMatch(scene -> scene.existBehaviorName(name));
	}

	@Override
	public void removeBehaviorIndex(int fileSelected) {}

	@Override
	public String getBehaviorFileIndex(int index) 
	{
		return "";
	}

	@Override
	public void setBehaviorFileText(Integer file, String text) {}

	public void evalBehaviors(EcmaScriptEngine engine) 
	{
		this.scenes.forEach(scene -> scene.evalBehaviors(engine));
	}

	public void actorsLearnAbilities(EcmaScriptEngine engine) 
	{
		this.scenes.forEach(scene -> scene.actorsLearnAbilities(engine));
	}

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
		this.scenes.forEach(scene -> scene.evalCollisions(engine));
	}

	@Override
	public void setPathAudio(String path) {}

	@Override
	public String getPathAudio() {
		return "";
	}

	@Override
	public void setPhysicsType(Physics type) {}

}
