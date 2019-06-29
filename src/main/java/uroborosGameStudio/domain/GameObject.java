package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.geometry.Dimension;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public abstract class GameObject implements Serializable
{
	private static final long serialVersionUID = 1L;
	String name = "";
	String ext = "";

	public String getName()
	{
		return this.name;
	}
	
	public String getExt()
	{
		return this.ext;
	}
	
	public abstract void setName(String name);

	public void saveFile(String savedPath) throws IOException
	{
		File file = new File(savedPath + getName() + getExt());
		
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}
	
	public void createFolder(String path) {
		File folder = new File(path);
		folder.mkdir();
	}
	
	public String line() { return System.getProperty("file.separator");	}

	public abstract void setSceneUEngine();

	public abstract SceneWrapper selectedScene(MainWindowModel model);

	public void setPosition(Integer x, Integer y) {};

	public Integer getX() {return 0;};

	public Integer getY() {return 0;};

	public String getPathImage(){return "";};

	public Integer getWidth(){return 0;};

	public Integer getHeight(){ return 0;};

	public void setPathImage(String path) {};

	public void setDimensionImage(Integer width, Integer height) {};

	public List<BehaviorFile> getBehaviors(){
		return new ArrayList<BehaviorFile>();
	};

	public void addBehavior(BehaviorFile newBehavior) {};

	public void removeBehaviorIndex(int fileSelected) {};

	public String getBehaviorFileIndex(int index){ return "";};

	public void setBehaviorFileText(Integer file, String text) {};

	public void setPhysicsBody(String body) {};

	public String getBody(){return "";};

	public Physics getPhysicsType(){return Physics.NONE;};

	public List<Collider> getColliders(){
		return new ArrayList<Collider>();
	};

	public void addCollision(Collider collition) {};

	public String getCollitionCode(int index){return "";};

	public void setCollitionText(Integer index, String text) {};

	public void removeCollisionIndex(int fileSelected) {};

	public abstract void setPathAudio(String path);

	public abstract String getPathAudio();

	public void setPhysicsType(Physics type) {}

	public void setAnimation (String image, int sprites, Dimension newDim, int ratio) {};

}
