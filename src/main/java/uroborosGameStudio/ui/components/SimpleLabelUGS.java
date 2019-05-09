package uroborosGameStudio.ui.components;

import java.awt.Label;

import javax.swing.JPanel;

public class SimpleLabelUGS 
{

	public SimpleLabelUGS(String text, JPanel panel) 
	{
		Label label = new Label(text);
		panel.add(label);
	}

}
