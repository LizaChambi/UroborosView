package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;

import uroborosGameStudio.domain.GameObject;

public class BtnEditNameAL extends AbstractEditionListener
{
	private JTextField textField;

	public BtnEditNameAL(JTree treeScenes, JTextField textField) 
	{
		super(treeScenes);
		this.textField = textField;
	}

	@Override
	public void updateComponents() {
		treeScenes.updateUI();
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		gameObject.setName(textField.getText());
	}

}
