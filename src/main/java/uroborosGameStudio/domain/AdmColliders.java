package uroborosGameStudio.domain;

import java.util.ArrayList;
import java.util.List;

public class AdmColliders 
{
	private List<Collider> colliders;
	
	public AdmColliders()
	{
		this.colliders = new ArrayList<Collider>();
	}

	public List<Collider> getColliders() {
		return colliders;
	}
	
	public void addCollider(Collider collider)
	{
		this.colliders.add(collider);
	}

	public Collider getCollitionIndex(int index) 
	{
		return this.colliders.get(index);
	}

	public void removeColliderIndex(int index) 
	{
		this.colliders.remove(index);
	}

}
