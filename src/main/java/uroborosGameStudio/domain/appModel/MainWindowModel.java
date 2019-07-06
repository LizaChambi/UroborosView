package uroborosGameStudio.domain.appModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.script.ScriptException;

import org.team.uroboros.uroboros.engine.Game;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class MainWindowModel 
{
	private UGSProject project;
	private GameObject itemSelected;
	private Integer fileBehaviorSelected;
	private Integer fileColliderSelected;
	
	public MainWindowModel() {}
	
	public UGSProject getProject() 
	{
		return project;
	}

	public void createNewProject() 
	{
		this.project = new UGSProject("UGSProject", "T\u00EDtulo del Juego");
	}

	public String getProjectName() 
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
	
	public boolean validateNameScene(String name) {
		return this.project.existSceneName(name);
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

	public boolean validateNameBehavior(String name) 
	{
		return this.project.existBehaviorName(name);
	}

	public void setDataTable(GameObject gameObject) 
	{
		this.itemSelected = gameObject;
	}

	public String getBehaviorFile(int index) 
	{
		return itemSelected.getBehaviorFileIndex(index);
	}

	public void setFileSelected(int row) 
	{
		this.fileBehaviorSelected = row;
	}
	
	public GameObject getItemSelected()
	{
		return this.itemSelected;
	}

	public void setTextBehaviorFile(String text) 
	{
		this.itemSelected.setBehaviorFileText(fileBehaviorSelected, text);
	}

	public void evalBehaviorsAndCollisions() 
	{
		EcmaScriptEngine engine = new EcmaScriptEngine(this.project.getPathRoot());
		
		try {
			evalImportsUEngine(engine);
			this.project.evalBehaviors(engine);
			this.project.actorsLearnAbilities(engine);
			this.project.evalCollisions(engine);
		} 
		catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void evalImportsUEngine(EcmaScriptEngine engine) throws ScriptException 
	{
		engine.eval("var Game = Java.type('org.team.uroboros.uroboros.engine.Game')");
		engine.eval("var GameObject = Java.type('org.team.uroboros.uroboros.engine.GameObject')");
		engine.eval("var Actor = Java.type('org.team.uroboros.uroboros.engine.component.Actor')");
		engine.eval("var Scene = Java.type('org.team.uroboros.uroboros.engine.component.Scene')");
		engine.eval("var Frame = Java.type('org.team.uroboros.uroboros.engine.ui.resources.Frame')");
		engine.eval("var SpriteSheet = Java.type('org.team.uroboros.uroboros.engine.ui.resources.SpriteSheet')");
		engine.eval("var Sprite = Java.type('org.team.uroboros.uroboros.engine.ui.resources.Sprite')");
		engine.eval("var Animation = Java.type('org.team.uroboros.uroboros.engine.ui.resources.Animation')");
		engine.eval("var Audio = Java.type('org.team.uroboros.uroboros.engine.audio.Audio')");
		engine.eval("var TextureRenderer = Java.type('org.team.uroboros.uroboros.engine.ui.TextureRenderer')");
		engine.eval("var Point = Java.type('org.team.uroboros.uroboros.engine.geometry.Point')");
		engine.eval("var Key = Java.type('org.team.uroboros.uroboros.engine.input.Key')");
		engine.eval("var Dimension = Java.type('org.team.uroboros.uroboros.engine.geometry.Dimension')");
		engine.eval("var Graphics = Java.type('org.team.uroboros.uroboros.engine.ui.Graphics')");
		engine.eval("var Ability = Java.type('org.team.uroboros.uroboros.engine.component.Ability')");
		engine.eval("var Behaviour = Java.type('org.team.uroboros.uroboros.engine.component.Behaviour')");
	}

	public void setFileCollisionSelected(int row) 
	{
		this.fileColliderSelected = row;
	}

	public String getCollitionCode(int row) 
	{
		return this.itemSelected.getCollitionCode(row);
	}

	public void setTextCollition(String text) 
	{
		this.itemSelected.setCollitionText(fileColliderSelected, text);
	}

	public void playAudio() 
	{
		getCurrentScene().playAudio();
	}

	private SceneWrapper getCurrentScene() {
		return this.searchScene(Game.getCurrentScene().getName());
	}

	public void stopAudio() 
	{
		getCurrentScene().stopAudio();
	}

	public String getPathProject() 
	{
		return this.project.getPathRoot();
	}

}
