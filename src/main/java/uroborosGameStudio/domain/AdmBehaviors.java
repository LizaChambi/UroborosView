package uroborosGameStudio.domain;

import java.util.ArrayList;
import java.util.List;

public class AdmBehaviors 
{
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
}
