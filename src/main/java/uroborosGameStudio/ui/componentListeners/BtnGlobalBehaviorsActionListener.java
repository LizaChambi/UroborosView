package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import uroborosGameStudio.ui.GlobalBehaviorDialog;
import uroborosGameStudio.ui.NewActorDialog;

public class BtnGlobalBehaviorsActionListener implements ActionListener 
{

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		GlobalBehaviorDialog dialog = new GlobalBehaviorDialog();
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

}
