package uroborosGameStudio.domain.appModel;

import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.UGSProject;

public class MainWindowModel 
{
	private UGSProject project;
	
	String itemSelectComboBox;
	

	public MainWindowModel()
	{
		this.itemSelectComboBox = "";
	}

	public void createNewProyect() 
	{
		this.project = new UGSProject("UGSProject", "GameTitle");
	}

	public String getProyectName() 
	{
		return project.getProjectName();
	}
	
	public String getGameTitle() 
	{
		return project.getProjectName();
	}

	public Integer cantScenes() 
	{
		return project.getScenes().size();
	}

	public Scene getSceneIn(int index) 
	{
		return project.getScenes().get(index);
	}
	
	public String getItemSelectComboBox() {
		return itemSelectComboBox;
	}

	public void setItemSelectComboBox(String msg) {
		itemSelectComboBox = msg;
	}

	public UGSProject getProject() {
		return project;
	}

	public void setProject(UGSProject project) {
		this.project = project;
	}

}
