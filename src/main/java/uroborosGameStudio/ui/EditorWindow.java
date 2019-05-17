package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.dummy.DummyActors;
import uroborosGameStudio.ui.componentListeners.BtnDeleteAL;
import uroborosGameStudio.ui.componentListeners.BtnEditDimensionImageActionListener;
import uroborosGameStudio.ui.componentListeners.BtnEditImageActionListener;
import uroborosGameStudio.ui.componentListeners.BtnEditNameAL;
import uroborosGameStudio.ui.componentListeners.BtnEditPositionAL;
import uroborosGameStudio.ui.componentListeners.BtnNewActorAL;
import uroborosGameStudio.ui.componentListeners.BtnNewSceneAL;
import uroborosGameStudio.ui.componentListeners.BtnOpenImageActionListener;
import uroborosGameStudio.ui.componentListeners.BtnPlayAL;
import uroborosGameStudio.ui.componentListeners.BtnSaveProjectAL;
import uroborosGameStudio.ui.componentListeners.SceneTreePanelTSL;
import uroborosGameStudio.ui.components.ActorsPanel;

public class EditorWindow extends AbstractWindowFrame {

	final DummyActors bdActors = new DummyActors();
	private int idScene = 1;
	
	private Canvas canvas = new Canvas();
	private Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel principalPanel;
	private JPanel buttonPanel;
	private JScrollPane eastPanel;
	private JPanel gameEditorPanel;
	private JPanel treePlayPanel;
	private JPanel editorPanel;
	private JPanel propertiesEditPanel;
	private JPanel editNamePanel;
	private JTextArea textArea = new JTextArea(1, 1);
	private JScrollPane scroollPanel;
	private JPanel playPanel;
	private JTree treeScenes = new JTree();
	private ActorsPanel actorsPanel = new ActorsPanel();
	private JTextField nameTextField = new JTextField("");
	private JTextField posXTextField = new JTextField("0");
	private JTextField posYTextField = new JTextField("0");
	private JPanel panelEditPosition;
	private JPanel panelEditImage;
	private JLabel lblImage;
	private JPanel panelEditDimension;
	private JLabel lblDimension;
	private JTextField textFieldPathImage = new JTextField("");
	private JButton btnSetImage;
	private JTextField textFieldWidth = new JTextField("0");
	private JTextField textFieldHigh = new JTextField("0");
	private JButton btnEditDimension;
	private JButton btnEditImage;
	public EditorWindow() 
	{
		super();
		this.initializeFrame();

		this.initializeGlobalPanel();
		this.initializeNorthPanel();
		this.initializeButtonPanel();
		this.toolbar();

		this.initializeCenterPanel();
		
		this.initializeTextPanel();
		this.initializeGameEditorPanel();
		
		this.initializeTreePlayPanel();
	
		this.initializeEditorPanel();
		this.initializePropertiesEditPanel();
		this.optionsEditorPanel();
		
		this.initializeTreePanel();
		this.initializePlayPanel();
		
		this.initializeCanvas();
		this.initializeCodeTextArea();
		//playPanel.add(actorsPanel);
		
		this.frame.pack();
	}
	
	private void initializeFrame() {
		this.frame.setSize(this.resolution);
		this.frame.setPreferredSize(this.resolution);
		this.frame.setMinimumSize(new Dimension(800,600));
		this.frame.setResizable(true);
	}
	
	private void initializeGlobalPanel() {
		principalPanel = new JPanel(new BorderLayout());
		principalPanel.setPreferredSize(new Dimension(resolution.width, resolution.height-30) );
		this.frame.getContentPane().add(principalPanel, BorderLayout.CENTER);
	}
	
	private void initializeButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(800, 40));
		FlowLayout fl_buttonPanel = new FlowLayout(FlowLayout.LEADING, 5, 5);
		buttonPanel.setLayout(fl_buttonPanel);
		this.northPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void toolbar() 
	{
		JButton btnNewScena = new JButton("Nueva Escena");
		btnNewScena.addActionListener(new BtnNewSceneAL(treeScenes, idScene, canvas));
		buttonPanel.add(btnNewScena);
		
		JButton btnNewActor = new JButton("Nuevo Actor");
		btnNewActor.addActionListener(new BtnNewActorAL(treeScenes, canvas, model, actorsPanel));
		buttonPanel.add(btnNewActor);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new BtnSaveProjectAL(this.getModelObject()));
		buttonPanel.add(btnSave);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new BtnPlayAL(canvas));
		buttonPanel.add(btnPlay);
		
		JButton btnRemove = new JButton("Eliminar");
		btnRemove.addActionListener(new BtnDeleteAL(treeScenes, canvas, nameTextField, posXTextField, posYTextField, textFieldPathImage, textFieldWidth, textFieldHigh, model));
		buttonPanel.add(btnRemove);
		
		/*
		new ButtonUGS("Nueva Escena", new BtnNewSceneAL(treeScenes, idScene, canvas), buttonPanel);
		new ButtonUGS("Nuevo Actor", new BtnNewActorAL(treeScenes, canvas, model), buttonPanel);
		new ButtonUGS("Guardar", new BtnSaveProjectAL(this.getModelObject()), buttonPanel);
		new ButtonUGS("Play", new BtnPlayAL(canvas), buttonPanel);
		*/
	}

	private void initializeCanvas() 
	{
		this.canvas.setFocusable(true);
		this.canvas.setPreferredSize(new Dimension(666, 400));
		this.canvas.setFocusTraversalKeysEnabled(true);
		this.canvas.setBackground(Color.GREEN);
		this.playPanel.add(this.canvas);
	}
	
	private void initializePlayPanel() {
		playPanel = new JPanel(new BorderLayout());
		playPanel.setPreferredSize(new Dimension(666, 400));
		playPanel.add(new ActorsPanel());
		this.treePlayPanel.add(playPanel, BorderLayout.CENTER);
	}
	
	private void initializeCodeTextArea() {
		textArea.setText("Editor de texto...");
	}

	private void initializeTreePanel() {
		scroollPanel = new JScrollPane(this.treeScenes);
		scroollPanel.setPreferredSize(new Dimension(307, 400));
		DefaultMutableTreeNode root = createTreeNode();
		DefaultTreeModel tree = new DefaultTreeModel(root);
		treeScenes.addTreeSelectionListener(new SceneTreePanelTSL(treeScenes,nameTextField,canvas, model, posXTextField, posYTextField, textFieldPathImage,textFieldWidth,textFieldHigh, actorsPanel));
		treeScenes.setModel(tree);
		this.treePlayPanel.add(scroollPanel, BorderLayout.LINE_START);
	}
	
	private DefaultMutableTreeNode createTreeNode() 
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(model.getProject());
		for (int i=0; i < model.cantScenes(); i++)
		{
			SceneWrapper scene = model.getSceneIn(i);
			DefaultMutableTreeNode child1 = new DefaultMutableTreeNode();
			child1.setUserObject(scene);
			for (int si=0; si<scene.cantActors();si++)
			{
				DefaultMutableTreeNode child11 = new DefaultMutableTreeNode();
				child11.setUserObject(scene.getActorIn(si));
				child1.add(child11);
			}
			root.add(child1);
		}
		return root;
	}

	private void initializeEditorPanel() 
	{
		editorPanel = new JPanel();
		editorPanel.setPreferredSize(new Dimension(973, 263));
		this.gameEditorPanel.add(editorPanel, BorderLayout.SOUTH);
	}
	
	private void initializePropertiesEditPanel() 
	{
		editorPanel.setLayout(null);
		propertiesEditPanel = new JPanel();
		propertiesEditPanel.setBounds(12, 12, 947, 239);
		propertiesEditPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Panel de configuraci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		propertiesEditPanel.setPreferredSize(new Dimension(973, 35));
		propertiesEditPanel.setLayout(new GridLayout(5, 1, 5, 0));
		this.editorPanel.add(propertiesEditPanel);
	}
	
	private void optionsEditorPanel() 
	{
		editName();
		editPosition();
		editImage();
		editDimension();
		
		/*
		new JLabelUGS("Panel de Configuraci\u00F3n:", titleEditorPanel);
		
		new JLabelUGS("Nombre:", optionsEditorPanel, 28, 60, 72, 23);
		nameTextField = new TextFieldUGS("",optionsEditorPanel, 110, 62, 100, 23, 10).getTextField();
		new ButtonUGS("Editar", new BtnEditNameAL(treeScenes,nameTextField, canvas), optionsEditorPanel, 230, 62, 100, 23);
	
		new JLabelUGS("Posición (x, y):", optionsEditorPanel, 350, 60, 80, 23);
		posXTextField = new TextFieldUGS("0",optionsEditorPanel, 450, 62, 50, 23,5).getTextField();
		posYTextField = new TextFieldUGS("0",optionsEditorPanel, 500, 62, 50, 23,5).getTextField();
		new ButtonUGS("Editar", new BtnEditPositionAL(treeScenes,posXTextField, posYTextField, canvas, model), optionsEditorPanel, 550, 62, 100, 23);
		*/
	}

	private void editDimension() {
		inicializedEditDimensionPanel();
		
		lblDimension = new JLabel("Dimensiones:");
		panelEditDimension.add(lblDimension);
		
		//textFieldWidth = new JTextField();
		//textFieldWidth.setText("0");
		panelEditDimension.add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		//textFieldHigh = new JTextField();
		//textFieldHigh.setText("0");
		panelEditDimension.add(textFieldHigh);
		textFieldHigh.setColumns(10);
		
		btnEditDimension = new JButton("Editar");
		btnEditDimension.addActionListener(new BtnEditDimensionImageActionListener(treeScenes, canvas, textFieldWidth, textFieldHigh, model));
		panelEditDimension.add(btnEditDimension);
	}

	private void inicializedEditDimensionPanel() {
		panelEditDimension = new JPanel();
		panelEditDimension.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 2));
		propertiesEditPanel.add(panelEditDimension);
	}

	private void editImage() {
		inicializedEditImagePanel();
		panelEditImage.setLayout(null);
		
		lblImage = new JLabel("Imágen:");
		lblImage.setBounds(5, 10, 57, 15);
		panelEditImage.add(lblImage);
		
		textFieldPathImage = new JTextField();
		textFieldPathImage.setEditable(false);
		textFieldPathImage.setBounds(67, 8, 165, 19);
		panelEditImage.add(textFieldPathImage);
		textFieldPathImage.setColumns(10);
		
		btnSetImage = new JButton("Imagen...");
		btnSetImage.addActionListener(new BtnOpenImageActionListener(textFieldPathImage,principalPanel, btnEditImage));
		btnSetImage.setBounds(237, 5, 101, 25);
		panelEditImage.add(btnSetImage);
		
		btnEditImage = new JButton("Editar");
		btnEditImage.addActionListener(new BtnEditImageActionListener(treeScenes, canvas, textFieldPathImage, model));
		btnEditImage.setBounds(345, 5, 76, 25);
		panelEditImage.add(btnEditImage);
	}

	private void inicializedEditImagePanel() {
		panelEditImage = new JPanel();
		propertiesEditPanel.add(panelEditImage);
	}

	private void editPosition() {
		inicializedEditPositionPanel();
		panelEditPosition.setLayout(null);
		
		JLabel lblPosition = new JLabel("Posición (x, y):");
		panelEditPosition.add(lblPosition);
		lblPosition.setBounds(5, 7, 102, 15);
		
		posXTextField = new JTextField("0");
		panelEditPosition.add(posXTextField);
		posXTextField.setBounds(112, 5, 112, 19);
		posXTextField.setColumns(5);
		
		posYTextField = new JTextField("0");
		panelEditPosition.add(posYTextField);
		posYTextField.setBounds(226, 5, 112, 19);
		posYTextField.setColumns(5);
		
		JButton btnEditPosition = new JButton("Editar");
		panelEditPosition.add(btnEditPosition);
		btnEditPosition.setBounds(344, 2, 76, 25);
		btnEditPosition.addActionListener(new BtnEditPositionAL(treeScenes,posXTextField, posYTextField, canvas, model));
	}

	private void inicializedEditPositionPanel() {
		panelEditPosition = new JPanel();
		propertiesEditPanel.add(panelEditPosition);
	}

	private void editName() {
		inicializedEditNamePanel();
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(28, 60, 72, 23);
		editNamePanel.add(lblName);

		nameTextField = new JTextField("");
		nameTextField.setBounds(110, 62, 100, 23);
		nameTextField.setColumns(10);
		editNamePanel.add(nameTextField);
		
		JButton btnEditName = new JButton("Editar");
		btnEditName.addActionListener(new BtnEditNameAL(treeScenes,nameTextField, canvas));
		btnEditName.setBounds(230, 62, 100, 23);
		editNamePanel.add(btnEditName);
	}

	private void inicializedEditNamePanel() 
	{
		editNamePanel = new JPanel();
		editNamePanel.setPreferredSize(new Dimension(973, 228));
		editNamePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 2));
		propertiesEditPanel.add(editNamePanel);
	}

	private void initializeTreePlayPanel() {
		BorderLayout bl_treePlayPanel = new BorderLayout();
		bl_treePlayPanel.setHgap(5);
		bl_treePlayPanel.setVgap(5);
		treePlayPanel = new JPanel(bl_treePlayPanel);
		treePlayPanel.setPreferredSize(new Dimension(973, 400));
		this.gameEditorPanel.add(treePlayPanel, BorderLayout.WEST);
	}

	private void initializeGameEditorPanel() {
		BorderLayout bl_gameEditorPanel = new BorderLayout();
		bl_gameEditorPanel.setVgap(5);
		bl_gameEditorPanel.setHgap(5);
		gameEditorPanel = new JPanel(bl_gameEditorPanel);
		gameEditorPanel.setPreferredSize(new Dimension(973, 663));
		this.centerPanel.add(gameEditorPanel, BorderLayout.CENTER);
	}

	private void initializeTextPanel() {
		eastPanel = new JScrollPane(this.textArea);
		eastPanel.setPreferredSize(new Dimension (393, 663) );
		this.centerPanel.add(eastPanel, BorderLayout.EAST);
	}
	
	private void initializeNorthPanel() {
		northPanel = new JPanel(new BorderLayout());
		northPanel.setPreferredSize(new Dimension(resolution.width, 75) );
		this.principalPanel.add(northPanel, BorderLayout.NORTH);
	}
	
	private void initializeCenterPanel() {
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(resolution.width, 663));
		this.principalPanel.add(centerPanel, BorderLayout.CENTER);
	}
	
	@Override
	protected void open() 
	{
		super.open();
		if(this.getFrame().isVisible() )
		{
			this.canvas.onFrameVisible();
		}
	}
}
