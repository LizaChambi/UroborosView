package uroborosGameStudio.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class BodyPath implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<String> paths;

	public BodyPath(ArrayList<String> pathsActor) {
		this.setPaths(pathsActor);
	}

	public ArrayList<String> getPaths() {
		return paths;
	}

	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}

}
