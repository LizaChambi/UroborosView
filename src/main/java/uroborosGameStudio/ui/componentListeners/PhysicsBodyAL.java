package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class PhysicsBodyAL implements ActionListener{

	private MainWindowModel model;
	private JComboBox cbox;

	public PhysicsBodyAL(MainWindowModel model, JComboBox cboxSelectBody) {
		this.model = model;
		this.cbox = cboxSelectBody;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cbox.getSelectedItem() != null) {
			model.getItemSelected().setPhysicsBody((String)cbox.getSelectedItem());
		}
	}

}
