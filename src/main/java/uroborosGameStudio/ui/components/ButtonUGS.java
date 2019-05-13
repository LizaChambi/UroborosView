package uroborosGameStudio.ui.components;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonUGS 
{
	private JButton button;
	
	public ButtonUGS(String text, ActionListener listener, JPanel panel) 
	{
		createSimpleButton(text, listener, panel);
	}

	public ButtonUGS(String text, ActionListener listener, JPanel panel, int x, int y, int width, int height) 
	{
		createSimpleButton(text, listener, panel).setBounds(x, y, width, height);
		
	}
	
	private JButton createSimpleButton(String text, ActionListener listener, JPanel panel) 
	{
		button = new JButton(text);
		button.addActionListener(listener);
		panel.add(button);
		return button;
	}
	
	public JButton getButton()
	{
		return this.button;
	}

}
