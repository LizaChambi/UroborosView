package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.dummy.DummyActors;
import uroborosGameStudio.ui.componentListeners.SceneTreePanelTSL;
import uroborosGameStudio.ui.componentListeners.BtnNewSceneAL;
import uroborosGameStudio.ui.componentListeners.BtnEditNameAL;
import uroborosGameStudio.ui.componentListeners.BtnNewActorAL;
import uroborosGameStudio.ui.componentListeners.BtnPlayAL;
import javax.swing.SwingConstants;

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
	private JComboBox<ActorWrapper> comboBox;
	private JScrollPane scroollPanel;
	private JPanel playPanel;
	private JButton sceneButton;
	private JTree treeScenes = new JTree();
	private JButton actorButton;
	private JButton saveButton;
	private JTextField nameTF = new JTextField("");
	private JLabel config;
	private JLabel nombre;
	private JButton btnEditName;
	private JButton btnPlay = new JButton("Play");

	public EditorWindow() {
		super();
		this.initializeFrame();
	
		this.initializePrincipalPanel();
		this.initializeNorthPanel();
		this.initializeButtonPanel();
		// Tool bar
		this.initializeNewSceneButton();
		this.initializeComboBox();
		this.initializeNewActorButton();
		this.initializeSaveButton();
		this.initializePlayButton();

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
		// this.frame.setLayout(new BorderLayout());
		this.frame.setSize(this.resolution);
		this.frame.setPreferredSize(this.resolution);
		this.frame.setMinimumSize(new Dimension(800,600));
		this.frame.setResizable(true);
		// this.frame.setVisible(false);
		
		// this.frame.setLocationRelativeTo(null);
	}
	
	private void initializeButtonPanel() {
		buttonPanel = new JPanel();
		// buttonPanel.setSize(800,75);
		buttonPanel.setPreferredSize(new Dimension(800, 40));
		FlowLayout fl_buttonPanel = new FlowLayout(FlowLayout.LEADING, 5, 5);
		buttonPanel.setLayout(fl_buttonPanel);
		this.northPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void initializePlayButton() 
	{
		this.btnPlay = new JButton("Play");
		btnPlay.addActionListener(new BtnPlayAL(canvas));
		buttonPanel.add(btnPlay);
	}
	
	private void initializeSaveButton() {
		this.saveButton = new JButton("Guardar");
		// saveButton.setBounds(500, 50, 97, 23);
		saveButton.setEnabled(false);
		buttonPanel.add(saveButton);
	}

	private void initializeNewActorButton() 
	{
		this.actorButton = new JButton("Nuevo Actor");
		actorButton.addActionListener(new BtnNewActorAL(treeScenes, comboBox, canvas));
		buttonPanel.add(actorButton);
	}

	private void initializeComboBox() {
		ActorWrapper ninio = bdActors.getKids();
		ActorWrapper pelota = bdActors.getBall();
		ActorWrapper piso = bdActors.getFlow();
		
		this.comboBox = new JComboBox<ActorWrapper>();
		comboBox.addItem(ninio);
		comboBox.addItem(pelota);
		comboBox.addItem(piso);

		comboBox.setPreferredSize(new Dimension(110,23));
		comboBox.setMaximumSize(new Dimension(110,23));
		buttonPanel.add(comboBox);
	}

	private void initializeNewSceneButton() {
		this.sceneButton = new JButton("Nueva Escena");
		sceneButton.addActionListener(new BtnNewSceneAL(treeScenes, idScene));
		buttonPanel.add(sceneButton);
	}

	private void initializeCanvas() {
		this.canvas.setFocusable(true);
		this.canvas.setFocusTraversalKeysEnabled(true);
		this.canvas.setBackground(Color.GREEN);
		this.playPanel.add(this.canvas);
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
		treeScenes.addTreeSelectionListener(new SceneTreePanelTSL(treeScenes,nameTF,canvas, model));
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
	
	private void optionsEditorPanel() {
		
		this.config = new JLabel("Panel de Configuraci\u00F3n:");
		titleEditorPanel.add(config);
		
		this.nombre = new JLabel("Nombre: ");
		nombre.setBounds(28, 60, 72, 23);
		optionsEditorPanel.add(nombre);
		nameTF.setToolTipText("");
		
		nameTF.setBounds(110, 62, 100, 23);
		optionsEditorPanel.add(nameTF);
		nameTF.setColumns(10);
		
		this.btnEditName = new JButton("Editar");
		btnEditName.setBounds(230, 62, 100, 23);
		btnEditName.addActionListener(new BtnEditNameAL(treeScenes,nameTF));
		optionsEditorPanel.add(btnEditName);
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
	
	private void initializePrincipalPanel() {
		principalPanel = new JPanel(new BorderLayout());
		principalPanel.setPreferredSize(new Dimension(resolution.width, resolution.height-30) );
		this.frame.getContentPane().add(principalPanel, BorderLayout.CENTER);
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
