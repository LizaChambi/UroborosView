package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.dummy.DummyActors;
import uroborosGameStudio.ui.componentListeners.BtnEditNameAL;
import uroborosGameStudio.ui.componentListeners.BtnEditPositionAL;
import uroborosGameStudio.ui.componentListeners.BtnNewActorAL;
import uroborosGameStudio.ui.componentListeners.BtnNewSceneAL;
import uroborosGameStudio.ui.componentListeners.BtnPlayAL;
import uroborosGameStudio.ui.componentListeners.BtnSaveProjectAL;
import uroborosGameStudio.ui.componentListeners.SceneTreePanelTSL;

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
	private JPanel titleEditorPanel;
	private JPanel optionsEditorPanel;
	private JTextArea textArea = new JTextArea(1, 1);
	private JScrollPane scroollPanel;
	private JPanel playPanel;
	private JTree treeScenes = new JTree();
	private JTextField nameTextField;
	private JTextField posXTextField;
	private JTextField posYTextField;

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
		this.initializeTitleEditorPanel();
		this.initializeOptionsEditorPanel();
		
		this.optionsEditorPanel();
		
		this.initializeTreePanel();
		this.initializePlayPanel();
		
		this.initializeCanvas();
		this.initializeCodeTextArea();
		
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
		btnNewActor.addActionListener(new BtnNewActorAL(treeScenes, canvas, model));
		buttonPanel.add(btnNewActor);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new BtnSaveProjectAL(this.getModelObject()));
		buttonPanel.add(btnSave);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new BtnPlayAL(canvas));
		buttonPanel.add(btnPlay);
		
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
		this.canvas.addOn(this.playPanel);
		// this.playPanel.add(this.canvas);
	}
	
	private void initializePlayPanel() {
		playPanel = new JPanel(new BorderLayout());
		playPanel.setPreferredSize(new Dimension(666, 400));
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
		treeScenes.addTreeSelectionListener(new SceneTreePanelTSL(treeScenes,nameTextField,canvas, model, posXTextField, posYTextField));
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

	private void initializeEditorPanel() {
		editorPanel = new JPanel(new BorderLayout());
		editorPanel.setPreferredSize(new Dimension(973, 263));
		this.gameEditorPanel.add(editorPanel, BorderLayout.SOUTH);
	}
	
	private void initializeTitleEditorPanel() {
		titleEditorPanel = new JPanel();
		titleEditorPanel.setPreferredSize(new Dimension(973, 35));
		FlowLayout fl_titlePanel = new FlowLayout(FlowLayout.LEADING, 5, 5);
		titleEditorPanel.setLayout(fl_titlePanel);
		this.editorPanel.add(titleEditorPanel, BorderLayout.NORTH);
	}
	
	private void initializeOptionsEditorPanel() {
		optionsEditorPanel = new JPanel();
		optionsEditorPanel.setPreferredSize(new Dimension(973, 228));
		FlowLayout fl_optionsPanel = new FlowLayout(FlowLayout.LEADING, 5, 5);
		optionsEditorPanel.setLayout(fl_optionsPanel);
		this.editorPanel.add(optionsEditorPanel, BorderLayout.SOUTH);
	}
	
	private void optionsEditorPanel() 
	{	
		JLabel lblTitleConf = new JLabel("Panel de Configuraci\u00F3n:");
		titleEditorPanel.add(lblTitleConf);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(28, 60, 72, 23);
		optionsEditorPanel.add(lblName);
		
		nameTextField = new JTextField("");
		nameTextField.setBounds(110, 62, 100, 23);
		nameTextField.setColumns(10);
		optionsEditorPanel.add(nameTextField);
		
		JButton btnEditName = new JButton("Editar");
		btnEditName.addActionListener(new BtnEditNameAL(treeScenes,nameTextField, canvas));
		btnEditName.setBounds(230, 62, 100, 23);
		optionsEditorPanel.add(btnEditName);
		
		JLabel lblPosition = new JLabel("Posición (x, y):");
		lblPosition.setBounds(350, 60, 80, 23);
		optionsEditorPanel.add(lblPosition);
		
		posXTextField = new JTextField("0");
		posXTextField.setBounds(450, 62, 50, 23);
		posXTextField.setColumns(5);
		optionsEditorPanel.add(posXTextField);
		
		posYTextField = new JTextField("0");
		posYTextField.setBounds(500, 62, 50, 23);
		posYTextField.setColumns(5);
		optionsEditorPanel.add(posYTextField);
		
		JButton btnEditPosition = new JButton("Editar");
		btnEditPosition.addActionListener(new BtnEditPositionAL(treeScenes,posXTextField, posYTextField, canvas, model));
		btnEditPosition.setBounds(550, 62, 100, 23);
		optionsEditorPanel.add(btnEditPosition);
		
		/*
		new JLabelUGS("Panel de Configuraci\u00F3n:", titleEditorPanel);
		
		new JLabelUGS("Nombre:", optionsEditorPanel, 28, 60, 72, 23);
		nameTextField = new TextFieldUGS("",optionsEditorPanel, 110, 62, 100, 23, 10).getTextField();
		new ButtonUGS("Editar", new BtnEditNameAL(treeScenes,nameTextField, canvas), optionsEditorPanel, 230, 62, 100, 23);
	
<<<<<<< HEAD
		new LabelUGS("Posici\u00f3n (x, y):", optionsEditorPanel, 350, 60, 80, 23);
=======
		new JLabelUGS("Posición (x, y):", optionsEditorPanel, 350, 60, 80, 23);
>>>>>>> aac35a59885f7445ba4afee16774965dbe41dfcf
		posXTextField = new TextFieldUGS("0",optionsEditorPanel, 450, 62, 50, 23,5).getTextField();
		posYTextField = new TextFieldUGS("0",optionsEditorPanel, 500, 62, 50, 23,5).getTextField();
		new ButtonUGS("Editar", new BtnEditPositionAL(treeScenes,posXTextField, posYTextField, canvas, model), optionsEditorPanel, 550, 62, 100, 23);
		*/
	}

	private void initializeTreePlayPanel() {
		treePlayPanel = new JPanel(new BorderLayout());
		treePlayPanel.setPreferredSize(new Dimension(973, 400));
		this.gameEditorPanel.add(treePlayPanel, BorderLayout.WEST);
	}

	private void initializeGameEditorPanel() {
		gameEditorPanel = new JPanel(new BorderLayout());
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

	/* 	ELIMINAR UN NODO DEL ARBOL DE DIRECCIONES
	 * 
	protected void removeNode(ActionEvent e) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel mdl = (DefaultTreeModel) treeScenes.getModel();
			mdl.removeNodeFromParent(lastNode);
		}
	}
	*/

}
