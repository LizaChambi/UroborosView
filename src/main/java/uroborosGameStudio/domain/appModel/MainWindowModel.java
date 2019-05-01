package uroborosGameStudio.domain.appModel;

import uroborosGameStudio.domain.GameObject;
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

	public void addActorToScene(GameObject newActor, SceneWrapper scene) 
	{
		System.out.println(scene.getName());
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
		this.project.saveProject();
	}

}
