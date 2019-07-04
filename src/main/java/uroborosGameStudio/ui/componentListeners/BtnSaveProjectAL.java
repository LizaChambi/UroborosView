package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnSaveProjectAL implements ActionListener {

	private MainWindowModel model;

	public BtnSaveProjectAL(MainWindowModel modelObject) {
		this.model = modelObject;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.save();
	}

}
