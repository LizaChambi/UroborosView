package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CloseWindowDialogAL implements ActionListener {

	private JDialog dialog;

	public CloseWindowDialogAL(JDialog newActorDialog) {
		this.dialog = newActorDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dialog.dispose();
	}
	
}
