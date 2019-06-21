package uroborosGameStudio.ui.componentListeners;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnEditNameAL extends AbstractEditionListener
{
	private JTextField textField;
	private MainWindowModel model;
	private JLabel lblError;

	public BtnEditNameAL(JTree treeScenes, JTextField textField,Canvas canvas, MainWindowModel model, JLabel lblErrorName) 
	{
		super(treeScenes, canvas);
		this.textField = textField;
		this.model = model;
		this.lblError = lblErrorName;
	}

	@Override
	public void updateComponents() {
		treeScenes.updateUI();
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		String name = textField.getText();
		if (!name.isEmpty()) {
			validateName(name, gameObject);
		}
		else {
			changeStatus("Por favor, ingrese un nombre para el Actor.");
		}
		
	}

	private void changeStatus(String info) {
		lblError.setText(info);
	}

	private void validateName(String name, GameObject gameObject) {
		if (!isValidName(name)) {
			notifyError(name);
		} else {
			notifyPass(name, gameObject);
		}
	}

	private void notifyPass(String name, GameObject gameObject) {
		changeStatus("");
		gameObject.setName(textField.getText());
	}

	private void notifyError(String name) {
		if(model.validateName(name)) {
			changeStatus("El nombre ingresado ya está en uso.");
		}
	}

	private boolean isValidName(String name) {
		return !model.validateName(name);
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
	}

}
