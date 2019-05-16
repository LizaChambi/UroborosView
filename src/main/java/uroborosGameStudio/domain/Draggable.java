package uroborosGameStudio.domain;

import javax.swing.JLabel;

public class Draggable 
{
	private String key;
	private JLabel label;
	
	public Draggable(String name, JLabel label) 
	{
		this.key = name;
		this.label = label;
	}
	
}

