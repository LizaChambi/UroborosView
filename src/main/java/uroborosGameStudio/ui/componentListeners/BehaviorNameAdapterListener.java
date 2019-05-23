package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uroborosGameStudio.domain.AdmBehaviors;

public class BehaviorNameAdapterListener implements KeyListener 
{
	private JButton okButton;
	private AdmBehaviors datosDePrueba;
	private JLabel lblError;
	private JTextField nameTextField;
	
	public BehaviorNameAdapterListener(JButton okButton, AdmBehaviors datosDePrueba, JLabel lblError, JTextField nameTextField) 
	{
		this.okButton = okButton;
		this.datosDePrueba =datosDePrueba;
		this.lblError= lblError;
		this.nameTextField =nameTextField;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		String name = nameTextField.getText();
		if (! name.isEmpty())
		{
			validateNameBehavior(name);
		}
		else
		{
			changeStatus("Por favor, ingrese un nombre.", false);
		}
	}
	
	private void changeStatus(String info, boolean enable) 
	{
		lblError.setText(info);
		okButton.setEnabled(enable);
	}
	
	private void validateNameBehavior(String name) 
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
	
	private void notifyPass(String name) 
	{
		changeStatus("", true);
	}
	
	private void notifyError(String name) 
	{
		if(! isUppercase(name.substring(0, 1)))
		{
			changeStatus("La letra inicial del nombre debe estar en mayúscula.", false);
		}
		if(datosDePrueba.validateName(name))
		{
			changeStatus("El nombre ingresado ya está en uso.", false);
		}
	}
	
	private boolean isUppercase(String letter) 
	{
		return letter.contains(letter.toUpperCase());
	}
	
	private boolean isValidName(String name) 
	{
		String letter = name.substring(0, 1);
		return isUppercase(letter) && ! datosDePrueba.validateName(name);
	}

}
