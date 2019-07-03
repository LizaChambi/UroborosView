package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ClearConsoleActionListener implements ActionListener 
{
	private JTextArea txtAreaConsole;
	
	public ClearConsoleActionListener(JTextArea txtConsole) 
	{
		this.txtAreaConsole = txtConsole;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		txtAreaConsole.setText("");
	}

}
