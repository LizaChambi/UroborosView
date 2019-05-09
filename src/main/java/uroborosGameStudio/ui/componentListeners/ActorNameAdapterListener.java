package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class ActorNameAdapterListener implements KeyListener 
{
	JTextField textFieldName;
	JButton okButton;
	MainWindowModel model;
	
	public ActorNameAdapterListener(JTextField textFieldName, JButton okButton, MainWindowModel model) 
	{
		this.textFieldName = textFieldName;
		this.okButton = okButton;
		this.model = model;
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
			System.out.println("Por favor, ingrese un nombre para el actor.");
			this.okButton.setEnabled(false);
		}
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
		String letter = name.substring(0, 1);
		if(! isUppercase(name.substring(0, 1)))
		{
			System.out.println("Letra inicial: " + letter);
			System.out.println("Debe ingresar un nombre con letra inicial en mayuscula.");
			this.okButton.setEnabled(false);
		}
		
		if(model.validateName(name))
		{
			System.out.println("El nombre del actor ya está en uso.");
			this.okButton.setEnabled(false);
		}
	}

	private boolean isValidName(String name) 
	{
		String letter = name.substring(0, 1);
		return isUppercase(letter) && ! model.validateName(name);
	}

	private void notifyPass(String name) 
	{
		System.out.println("El nombre: " + name + " es válido.");
		this.okButton.setEnabled(true);
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
