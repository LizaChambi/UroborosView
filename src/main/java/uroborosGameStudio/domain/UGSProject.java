package uroborosGameStudio.domain;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.team.uroboros.uroboros.engine.Game;

public class UGSProject extends GameObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String projectName;
	private String pathRoot;
	private List<SceneWrapper> scenes;
	private List<String> savedScenes;
	
	public UGSProject(String projectName, String gameName) 
	{
		this.name = gameName;
		this.ext = ".ugs";
		this.savedScenes = new ArrayList<String>();
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
		deleteFile(getSavedPath());
		this.name = newTitle;
	}

	public SceneWrapper searchScene(String name) 
	{
		return this.scenes.stream().filter(scene -> scene.getName().equals(name)).findFirst().get();
	}
	
	public void saveProject() throws IOException
	{
		updateSavedScenes();
		saveScenes();
		saveFile(getSavedPath());
	}
	
	protected String getSavedPath() 
	{
		return getPathRoot() + System.getProperty("file.separator");
	}

	private void updateSavedScenes() 
	{
		setSavedScenes(this.scenes.stream().map(sce -> sce.getName()).collect(Collectors.toList()));
	}

	private void setSavedScenes(List<String> savedScenes) 
	{
		this.savedScenes = savedScenes;
	}
	
	private List<String> getSavedScenes() {
		return this.savedScenes;
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
