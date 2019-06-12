package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.EditorWindow;

public class CreateNewProjectAL implements ActionListener{

	private JFrame frame;
	private MainWindowModel model;

	public CreateNewProjectAL(JFrame frame, MainWindowModel model) {
		this.frame = frame;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.createNewProject();
		new EditorWindow().run();
		frame.dispose();
	}

}
