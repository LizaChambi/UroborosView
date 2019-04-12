package uroborosGameStudio.domain.appModel;

import uroborosGameStudio.domain.Actor;
import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.UGSProject;

public class MainWindowModel 
{
	private UGSProject project;
	
	public MainWindowModel()
	{
	}
	

	public UGSProject getProject() 
	{
		return project;
	}

	public void createNewProyect() 
	{
		this.project = new UGSProject("UGSProject", "Título del Juego");
	}

	public String getProyectName() 
	{
		return project.getProjectName();
	}
	
	public String getGameTitle() 
	{
		return project.getGameTitle();
	}

	public Integer cantScenes() 
	{
		return project.getScenes().size();
	}

	public Scene getSceneIn(int index) 
	{
		return project.getScenes().get(index);
	}


	public void addScene(Scene newScene) 
	{
		project.addScene(newScene);
	}


	public void addActorToScene(Actor newActor, Scene scene) 
	{
		System.out.println(scene.getName());
	}
	

}
