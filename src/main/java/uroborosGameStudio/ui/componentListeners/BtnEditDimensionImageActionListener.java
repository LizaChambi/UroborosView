package uroborosGameStudio.ui.componentListeners;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnEditDimensionImageActionListener extends AbstractEditionListener
{
	private JTextField widthField;
	private JTextField heightField;
	private MainWindowModel model;
	private JLabel lblError;
	
	public BtnEditDimensionImageActionListener(JTree treeScenes, Canvas canvas, JTextField textFieldWidth, JTextField textFieldHigh, MainWindowModel model, JLabel lblErrorDimension) 
	{
		super(treeScenes, canvas);
		this.widthField = textFieldWidth;
		this.heightField = textFieldHigh;
		this.model = model;
		this.lblError = lblErrorDimension;
	}

	@Override
	public void updateComponents(GameObject gameObject) {
		String width = this.widthField.getText();
		String height = this.heightField.getText();
		
		if(!width.isEmpty() && !height.isEmpty()) {
			validateNumber(gameObject, width, height);
		} else { 
			lblError.setText("Por favor, ingrese un n\u00famero"); 
		}
	}

	private void validateNumber(GameObject gameObject, String width, String height) {
		String regex = ".*[0-9]";
		if(width.matches(regex) & height.matches(regex)) {
			gameObject.setDimensionImage(Integer.valueOf(width), Integer.valueOf(height));
			lblError.setText("");
			//Actualizar canvas: Notar que el gameObject siempre sera un actor y no puede venir null
			SceneWrapper selectedScene = gameObject.selectedScene(model);
			if (selectedScene != null) {
				setCanvas(selectedScene);
			}
		} else { lblError.setText("Solo ingresar n\u00fameros");	}
	}
	
	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
	}

}
