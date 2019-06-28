package uroborosGameStudio.ui.componentListeners;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.Physics;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.components.UGSRadioButton;

public class SceneTreePanelTSL extends AbstractEditionListener
{
	private JTextField textField;
	private JTextField posXField;
	private JTextField posYField;
	private JTextField pathImageField;
	private JTextField pathAudioField;
	private JTextField widthField;
	private JTextField heightField;
	private JComboBox<?> cboxBody;
	private UGSRadioButton rdStatic;
	private UGSRadioButton rdDynamic;
	private UGSRadioButton rdKinematic;
	private JTable collisionTable;
	private JTable behaviorsTable;
	private MainWindowModel model;
	private JTextArea textArea;
	
	public SceneTreePanelTSL(JTree treeScenes, JTextField textField, Canvas canvas, MainWindowModel model, JTextField posXTextField, JTextField posYTextField, JTextField textFieldPath, JTextField textFieldWidth, JTextField textFieldHigh, JTable table, JComboBox<?> cboxSelectBody, UGSRadioButton rdStatic, UGSRadioButton rdKinematic, UGSRadioButton rdDinamic, JTable tableCollision, JTextArea textArea,JTextField textAudioPath) 
	{
		super(treeScenes, canvas);
		this.textField = textField;
		this.pathAudioField = textAudioPath;
		this.posXField = posXTextField;
		this.posYField = posYTextField;
		this.pathImageField = textFieldPath;
		this.widthField = textFieldWidth;
		this.heightField = textFieldHigh;
		this.cboxBody = cboxSelectBody;
		this.rdDynamic = rdDinamic;
		this.rdKinematic = rdKinematic;
		this.rdStatic = rdStatic;
		this.model = model;
		this.collisionTable = tableCollision;
		this.behaviorsTable = table;
		this.textArea = textArea;
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		this.setTextFieldsPropertiesView(gameObject);
		textArea.setText("");
		gameObject.setSceneUEngine();
		SceneWrapper selectedScene = gameObject.selectedScene(model);
		if (selectedScene != null)
		{
			setCanvas(selectedScene);
		}
		this.updateTableBehavior(behaviorsTable, gameObject);
		model.setDataTable(gameObject);
		setSelectedBodyMaterialView(gameObject);
		this.setPhysicsBodyView(gameObject);
		this.updateTableCollider(collisionTable, gameObject);
		
		/* 
		 * Cada tipo de GameObject debe cambiar el panel de edición:
		 * 
		 * IDEA): Cambiar el panel de edición por un panel propio para Actores/Scenas/Proyecto:
		 * 		scrollPanelEdicion.setViewportView(panelDeEdicionDeScenes);
		 * 		scrollPanelEdicion.setViewportView(panelDeEdicionDeActores);
		 * 		scrollPanelEdicion.setViewportView(panelDeEdicionDelProyecto);
		 */
	}

	private void setSelectedBodyMaterialView(GameObject gameObject) 
	{
		String material = gameObject.getBody();
		if (material.isEmpty())
		{
			cboxBody.setSelectedItem(null);
		}
		else
		{
			cboxBody.setSelectedItem(material);
		}
	}

	private void setTextFieldsPropertiesView(GameObject gameObject) {
		textField.setText(gameObject.getName());
		posXField.setText(gameObject.getX().toString());
		posYField.setText(gameObject.getY().toString());
		pathImageField.setText(gameObject.getPathImage());
		widthField.setText(gameObject.getWidth().toString());
		heightField.setText(gameObject.getHeight().toString());
		pathAudioField.setText(gameObject.getPathAudio());	
	}

	private void setPhysicsBodyView(GameObject gameObject) 
	{
		rdStatic.setSelected(false);
		rdDynamic.setSelected(false);
		rdKinematic.setSelected(false);
		Physics type = gameObject.getPhysicsType();
		rdStatic.selectIt(type);
		rdDynamic.selectIt(type);
		rdKinematic.selectIt(type);
	}

	@Override
	public void updateComponents() {}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {}

}
