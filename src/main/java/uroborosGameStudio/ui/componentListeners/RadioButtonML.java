package uroborosGameStudio.ui.componentListeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import uroborosGameStudio.domain.Physics;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class RadioButtonML implements MouseListener{

	private MainWindowModel model;
	private String rdText;

	public RadioButtonML(MainWindowModel model, String rdText) {
		this.model = model;
		this.rdText = rdText;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.rdText == "Estático") {	model.getItemSelected().setPhysicsType(Physics.STATIC);; }
		if(this.rdText == "Cinemático") { model.getItemSelected().setPhysicsType(Physics.KINEMATIC); }
		if(this.rdText == "Dinámico") {	model.getItemSelected().setPhysicsType(Physics.DYNAMIC); }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
