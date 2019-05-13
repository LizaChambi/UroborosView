package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class ActorNameAdapterListener implements KeyListener 
{
	JTextField textFieldName;
	JButton okButton;
	MainWindowModel model;
	JLabel lblError;
	
	public ActorNameAdapterListener(JTextField textFieldName, JButton okButton, MainWindowModel model, JLabel lblError) 
	{
		this.textFieldName = textFieldName;
		this.okButton = okButton;
		this.model = model;
		this.lblError = lblError;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		String name = textFieldName.getText();
		if (! name.isEmpty())
		{
			validateNameActor(name);
		}
		else
		{
			changeStatus("Por favor, ingrese un nombre para el actor.", false);
		}
	}

	private void changeStatus(String info, boolean enable) 
	{
		lblError.setText(info);
		this.okButton.setEnabled(enable);
	}

	private void validateNameActor(String name) 
	{
		if (! isValidName(name))
		{
			notifyError(name);
		}
		else
		{
			notifyPass(name);
		}
	}

	private void notifyError(String name) 
	{
		if(! isUppercase(name.substring(0, 1)))
		{
			changeStatus("La letra inicial del nombre debe estar en mayúscula.", false);
		}
		if(model.validateName(name))
		{
			changeStatus("El nombre ingresado ya está en uso.", false);
		}
	}

	private boolean isValidName(String name) 
	{
		String letter = name.substring(0, 1);
		return isUppercase(letter) && ! model.validateName(name);
	}

	private void notifyPass(String name) 
	{
		changeStatus("", true);
	}

	private boolean isUppercase(String letter) 
	{
		return letter.contains(letter.toUpperCase());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
