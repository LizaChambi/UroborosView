package uroborosGameStudio.domain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.Game;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.exception.NombreVacioException;

public class UGSProject extends GameObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String projectName;
	private String pathRoot;
	private List<SceneWrapper> scenes;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.name = gameName;
		this.ext = ".ugs";
		this.projectName = projectName;
		createProjectDir();
		this.scenes = new ArrayList<SceneWrapper>();
		createMainScene();
	}

	private void createMainScene() {
		this.scenes.add(new SceneWrapper("Escena0"));
		Game.createScene("Escena0");
	}

	public String getPathRoot() {
		return this.pathRoot;
	}

	public List<SceneWrapper> getScenes() {
		return this.scenes;
	}

	public void createProjectDir() {
		String dp = System.getProperty("user.home");
		String line = System.getProperty("file.separator");
		File dir = new File(dp + line + this.projectName);
		createDir(dir);
	}

	public void createDir(File dir) {
		this.pathRoot = dir.getPath();
		dir.mkdir();
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
	
	public void saveProject() throws IOException
	{
		deleteOldProject();
		saveScenes();
		saveFile(getSavedPath());
	}
	
	private void deleteOldProject() 
	{
		File file = new File(getPathRoot()); 
		File[] ficheros = file.listFiles(); 
		if(file.exists()) 
		{ 
			for (int x=0;x<ficheros.length;x++) 
			{ 
				File fileToDelete = new File(ficheros[x].toString()); 
				fileToDelete.delete(); 
			}
		} 
		else 
		{ 
			System.out.println("No existe el directorio"); 
		}
	}

	public String getSavedPath() 
	{
		return getPathRoot() + System.getProperty("file.separator");
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
}
