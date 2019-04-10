package uroborosGameStudio.domain.appModel;

import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.UGSProyect;

public class MainWindowModel 
{
	private UGSProyect proyect;
	
	public MainWindowModel()
	{
	}

	public void createNewProyect() 
	{
		this.proyect = new UGSProyect("UGSProyect", "GameTitle");
	}

	public String getProyectName() 
	{
		return proyect.getProyectName();
	}
	
	public String getGameTitle() 
	{
		return proyect.getProyectName();
	}

	public Integer cantScenes() 
	{
		return proyect.getScenes().size();
	}

	public Scene getSceneIn(int index) 
	{
		return proyect.getScenes().get(index);
	}
	

}
