package uroborosGameStudio.domain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	private String pathBehavior;
	private String pathAbility;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.name = gameName;
		this.ext = ".ugs";
		this.projectName = projectName;
		createProjectDir();
		createFolderGlobalBehavior();
		createFolderGlobalAbility();
		this.scenes = new ArrayList<SceneWrapper>();
		createMainScene();
	}

	private void createMainScene() {
		SceneWrapper tmp = new SceneWrapper("Escena0");
		tmp.setPathScene(getSavedPath());
		this.scenes.add(tmp);
		Game.createScene("Escena0");
		tmp.createFolder(tmp.getPathScene() + "Escena0");
		toListOnlySubDirectories();
	}

	public String getPathRoot() {
		return this.pathRoot;
	}

	public List<SceneWrapper> getScenes() {
		return this.scenes;
	}

	public void createProjectDir() {
		String dp = System.getProperty("user.home");
		File dir = new File(dp + line() + this.projectName);
		createDir(dir);
	}

	public void createDir(File dir) {
		this.pathRoot = dir.getPath();
		dir.mkdir();
	}
	
	private void createFolderGlobalBehavior() {
		File behavior = new File(getSavedPath() + "Global Behavior");
		this.pathBehavior = behavior.getPath();
		behavior.mkdir();
	}
	
	private void createFolderGlobalAbility() {
		File ability = new File(getSavedPath() + "Global Ability");
		this.pathAbility = ability.getPath();
		ability.mkdir();
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void addScene(SceneWrapper newScene) {
		this.scenes.add(newScene);
		newScene.setPathScene(getSavedPath());
		Game.createScene(newScene.getName());
		newScene.createFolder(newScene.getPathScene() + newScene.getName());
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
	
	public void toListOnlySubDirectories() {
		Path dir = Paths.get(this.pathRoot);
		try {
			Files.walk(dir, 1)
			     .filter(p -> Files.isDirectory(p) && ! p.equals(dir))
			     .forEach(p -> System.out.println(p.getFileName()));
			
//			Delete Project
//			Files.walk(dir, 1)
//		      .sorted(Comparator.reverseOrder())
//		      .map(Path::toFile)
//		      .forEach(File::delete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveProject() throws IOException
	{
		deleteOldFiles(getPathRoot());
		saveScenes();
		saveFile(getSavedPath());
	}
	
	public String getSavedPath() 
	{
		return getPathRoot() + line();
	}

	private void saveScenes() 
	{
		this.scenes.forEach(esc -> {
			try 
			{
				esc.save(getSavedPath());
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
		this.scenes.forEach(scene -> scene.evalCollisions(engine));
	}

}
