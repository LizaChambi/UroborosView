package uroborosGameStudio.ui.componentListeners;

import javax.swing.JTextField;
import javax.swing.JTree;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;

public class btnEditNameAL extends AbstractEditionListener
{
	private JTextField textField;

	public btnEditNameAL(JTree treeScenes, JTextField textField) 
	{
		super(treeScenes);
		this.textField = textField;
	}

	@Override
	public void updateComponents() {
		treeScenes.updateUI();
	}

	@Override
	public void updateActor(ActorWrapper actorWpp) {
		actorWpp.setName(textField.getText());
	}

	@Override
	public void updateScene(SceneWrapper sceneWpp) {
		sceneWpp.setName(textField.getText());
	}

	@Override
	public void updateProject(UGSProject ugsGame) {
		ugsGame.setTitle(textField.getText());
	}

}
