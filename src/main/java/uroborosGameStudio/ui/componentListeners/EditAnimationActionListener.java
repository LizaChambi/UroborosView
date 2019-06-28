package uroborosGameStudio.ui.componentListeners;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.ConfigureAnimationDialog;

public class EditAnimationActionListener extends AbstractEditionListener 
{
	private JTextField pathImage;
	private JTextField cantSpritesField;
	private JTextField widthField;
	private JTextField heightField;
	private JSpinner spinnerRatio;
	private MainWindowModel model;
	private ConfigureAnimationDialog dialog;
	
	public EditAnimationActionListener(JTree treeScenes, Canvas canvas, JTextField textFieldImagen, JTextField textFieldNumFrames, JTextField textFieldWidth, JTextField textFieldHeight, JSpinner spinnerRatio, MainWindowModel model, ConfigureAnimationDialog spriteSheetDialog) {
		super(treeScenes, canvas);
		this.pathImage = textFieldImagen;
		this.cantSpritesField = textFieldNumFrames;
		this.widthField = textFieldWidth;
		this.heightField = textFieldHeight;
		this.spinnerRatio = spinnerRatio;
		this.model = model;
		this.dialog = spriteSheetDialog;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		String image = pathImage.getText();
		int sprites = Integer.parseInt(cantSpritesField.getText());
		Dimension newDim = new Dimension(Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()));
		int ratio = Integer.parseInt(spinnerRatio.getValue().toString());
		
		gameObject.setAnimation(image, sprites, newDim, ratio);
		setCanvas(gameObject.selectedScene(model));
	}

	@Override
	public void updateComponents() {
		dialog.dispose();
	}

}
