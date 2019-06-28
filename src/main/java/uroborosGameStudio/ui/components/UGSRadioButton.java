package uroborosGameStudio.ui.components;

import javax.swing.JRadioButton;

import uroborosGameStudio.domain.Physics;

public class UGSRadioButton extends JRadioButton 
{
	private static final long serialVersionUID = 1L;
	
	private Physics typeSelected;
	
	public UGSRadioButton(String name, Physics type) 
	{
		super(name, null, false);
		this.typeSelected = type;
	}

	public void selectIt(Physics type)
	{
		if (typeSelected.equals(type)) this.setSelected(true);
	}

	
}
