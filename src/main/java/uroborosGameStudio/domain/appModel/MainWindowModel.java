package uroborosGameStudio.domain.appModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.team.uroboros.uroboros.engine.Game;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class MainWindowModel 
{
	private UGSProject project;
	String itemSelectComboBox;

	public MainWindowModel()
	{
		this.itemSelectComboBox = "";
	}
	
	public UGSProject getProject() 
	{
		return project;
	}

	public void createNewProyect() 
	{
		this.project = new UGSProject("UGSProject", "T\u00EDtulo del Juego");
	}

	public String getProyectName() 
	{
		return project.getProjectName();
	}
	
	public String getGameTitle() 
	{
		return project.getName();
	}

	public Integer cantScenes() 
	{
		return project.getScenes().size();
	}

	public SceneWrapper getSceneIn(int index) 
	{
		return project.getScenes().get(index);
	}

	public void addScene(SceneWrapper newScene) 
	{
		project.addScene(newScene);
	}
	
	public String getItemSelectComboBox() {
		return itemSelectComboBox;
	}

	public void setItemSelectComboBox(String msg) {
		itemSelectComboBox = msg;
	}

	public void setProject(UGSProject project) {
		this.project = project;
	}

	public SceneWrapper searchScene(String name) 
	{
		return this.project.searchScene(name);
	}

	public void save() {
		try {
			this.project.saveProject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean validateName(String name) 
	{
		return this.project.existActorName(name);
	}

	public void loadProject(String path) 
	{
		try 
		{
			this.project = readFile(path);
		} catch (ClassNotFoundException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.project.loadProject();
	}
	
	private UGSProject readFile(String path)throws IOException, ClassNotFoundException 
	{
		FileInputStream file = new FileInputStream(path);
		ObjectInputStream input = new ObjectInputStream(file);
		UGSProject game = (UGSProject) input.readObject();
		input.close();
		return game;
	}

	public SceneWrapper deleteActor(ActorWrapper actor) {
		return project.deleteActor(actor);
	}
	
	public void deleteScene(SceneWrapper scene) {
		project.deleteScene(scene);
	}
}
