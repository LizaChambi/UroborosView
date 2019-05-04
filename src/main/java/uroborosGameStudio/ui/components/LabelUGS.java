package uroborosGameStudio.ui.components;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelUGS 
{

	public LabelUGS(String text, JPanel panel) 
	{
		createSimpleLabel(text, panel);
	}

	public LabelUGS(String text, JPanel panel, int x, int y, int width, int height) 
	{
		createSimpleLabel(text, panel).setBounds(x, y, width, height);
	}
	
	private JLabel createSimpleLabel(String text, JPanel panel) 
	{
		JLabel label = new JLabel(text);
		panel.add(label);
		return label;
	}

}
