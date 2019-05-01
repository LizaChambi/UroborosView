package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.team.uroboros.uroboros.engine.Game;

public class UGSProject extends GameObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String projectName;
	private String path;
	private List<SceneWrapper> scenes;
	private List<String> savedScenes;
	// private List<BodyPath> pathsScenes;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.name = gameName;
		this.ext = ".ugs";
		this.savedScenes = new ArrayList<String>();
		this.projectName = projectName;
		createProjectDir();
		this.scenes = new ArrayList<SceneWrapper>();
		createMainScene();
		// this.setPathsScenes(new ArrayList<BodyPath>());
	}

	private void createMainScene() {
		this.scenes.add(new SceneWrapper("Escena0"));
		Game.createScene("Escena0");
	}

	public String getPath() {
		return this.path;
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
		this.path = dir.getPath();
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
	public void setName(String newTitle) 
	{
		this.name = newTitle;
	}

	public SceneWrapper searchScene(String name) 
	{
		return this.scenes.stream().filter(scene -> scene.getName().equals(name)).findFirst().get();
	}
/*
	public List<BodyPath> getPathsScenes() {
		return pathsScenes;
	}

	public void setPathsScenes(List<BodyPath> pathsScenes) {
		this.pathsScenes = pathsScenes;
	}
*/	
	
	public void saveProject() throws IOException
	{
		updateSavedScenes();
		saveScenes();
		saveFile(getSavedPath());
		
		/*
		setPathsScenes(this.scenes.stream().map(scene -> scene.saveScene()).collect(Collectors.toList()));
		// list sorted
		getPathsScenes().get(0).getPaths().add(0, gameTitle + ".ugs");
//		System.out.println(getPathsScenes().get(0).getPaths());
		*/
	}
	
	private String getSavedPath() 
	{
		return getPath() + System.getProperty("file.separator");
	}

	private void updateSavedScenes() 
	{
		setSavedScenes(this.scenes.stream().map(sce -> sce.getName()).collect(Collectors.toList()));
	}

	// public void setPathsScenes(List<BodyPath> pathsScenes)
	private void setSavedScenes(List<String> savedScenes) 
	{
		this.savedScenes = savedScenes;
		//this.pathsScenes = pathsScenes;
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
}
