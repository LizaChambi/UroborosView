package uroborosGameStudio.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.team.uroboros.jtypescript.engine.EcmaScriptEngine;

public class AdmBehaviors implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<BehaviorFile> behaviors;
	
	public AdmBehaviors()
	{
		this.behaviors = new ArrayList<BehaviorFile>();
	}
	
	public void removeBehavior(BehaviorFile behavior)
	{
		this.behaviors.remove(behavior);
	}
	
	public void addBehavior(BehaviorFile behavior)
	{
		this.behaviors.add(behavior);
	}
	
	public List<BehaviorFile> getBehaviors()
	{
		return this.behaviors;
	}

	public void removeBehaviorIndex(int index) 
	{
		this.behaviors.remove(index);
	}

	public Boolean hasBehaviorName(String name) 
	{
		return this.behaviors.stream().anyMatch(behavior -> behavior.hasName(name));
	}

	public String getBehaviorFile(int index) 
	{
		return this.behaviors.get(index).getCode();
	}

	public void setCodeFile(Integer file, String text) 
	{
		this.behaviors.get(file).setCode(text);
	}

	public void evalBehaviorFiles(EcmaScriptEngine engine) 
	{
		this.behaviors.forEach(behavior -> behavior.evalCode(engine));
	}

	public void saveBehaviors(String savedPath) 
	{
		this.behaviors.forEach(behavior -> {
			try {
				behavior.saveFile(savedPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	public boolean hasBehaviors() 
	{
		return !this.behaviors.isEmpty();
	}
}
