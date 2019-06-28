package uroborosGameStudio.ui.componentListeners;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnEditPositionAL extends AbstractEditionListener 
{
	private JTextField posX;
	private JTextField posY;
	private MainWindowModel model;
	private JLabel lblError;
	
	public BtnEditPositionAL(JTree treeScenes, JTextField posX, JTextField posY, Canvas canvas, MainWindowModel model, JLabel lblErrorNumber) 
	{
		super(treeScenes, canvas);
		this.posX = posX;
		this.posY = posY;
		this.model = model;
		this.lblError = lblErrorNumber;
	}
	
	@Override
	public void updateComponents(GameObject gameObject) {
		String regex = ".*[0-9]";
		String x = this.posX.getText();
		String y = this.posY.getText();
		
		if(x.matches(regex) & y.matches(regex)) {
			gameObject.setPosition(Integer.parseInt(x), Integer.parseInt(y));
			lblError.setText("");
			//Actualizar canvas: Notar que el gameObject siempre sera un actor y no puede venir null
			SceneWrapper selectedScene = gameObject.selectedScene(model);
			if (selectedScene != null)
			{
				setCanvas(selectedScene);
			}
		} else 
		{ 
			lblError.setText("Solo se puede ingresar numeros");
			this.posX.setText(gameObject.getX().toString());
			this.posY.setText(gameObject.getY().toString());
		}
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
