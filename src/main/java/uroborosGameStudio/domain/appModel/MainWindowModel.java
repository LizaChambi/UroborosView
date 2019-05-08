package uroborosGameStudio.domain.appModel;

import java.io.IOException;

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

	public Boolean validName(String name) 
	{
		return this.project.existActorName(name);
	}
}
