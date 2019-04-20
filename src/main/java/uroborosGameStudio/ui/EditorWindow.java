package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Color.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.Actor;
import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.dummy.DummyActors;

public class EditorWindow implements Runnable, WindowListener, ComponentListener {

	MainWindowModel model;
	final DummyActors bdActors = new DummyActors();
	private int idScene = 1;
	JTextPane txtName = new JTextPane();
	
	private JFrame frame;
	private Canvas canvas;
	private String title = "Uroboros Game Studio";
	private Integer width = 1680;
	private Integer height = 1024;
	private Dimension dimension = new Dimension(width, height);
	private boolean resizable = true;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JScrollPane eastPanel;
	private JPanel gameEditorPanel;
	private JPanel treePlayPanel;
	private JPanel editorPanel;
	private JTextArea textArea = new JTextArea(1, 1);
	private JComboBox<Actor> comboBox;
	private JScrollPane scroollPanel;
	private JPanel playPanel;
	private JButton sceneButton;
	private JTree treeScenes = new JTree();
	private JButton actorButton;
	private JButton saveButton;
	private JTextField textField;
	private JLabel config;
	private JLabel nombre;

	public static void OpenWindow(MainWindowModel model) {
		new EditorWindow(model).run();
	}

	public EditorWindow(MainWindowModel model) {
		this.initializeFrame(model);
		
		this.initializeNorthPanel();
		this.initializeCenterPanel();
		
		this.initializeTextPanel();
		this.initializeGameEditorPanel();
		
		this.initializeTreePlayPanel();
		this.initializeEditorPanel();
		
		this.initializeTreePanel();
		this.initializePlayPanel();
		
		this.initializeCanvas();
		this.initializeCodeTextArea();
		
		// Tool bar
		this.initializeNewSceneButton();
		this.initializeComboBox();
		this.initializeNewActorButton();
		this.initializeSaveButton();
	}

	private void initializeSaveButton() {
		this.saveButton = new JButton("Guardar");
		saveButton.setBounds(500, 155, 97, 23);
		saveButton.setEnabled(false);
		northPanel.add(saveButton);
	}

	private void initializeNewActorButton() {
		this.actorButton = new JButton("Nuevo Actor");
		actorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActor(e);
				setItemSelectComboBox(e);
			}
		});
		actorButton.setBounds(350, 155, 116, 23);
		northPanel.add(actorButton);
	}

	private void initializeComboBox() {
		Actor ninio = bdActors.getKids();
		Actor pelota = bdActors.getBall();
		Actor piso = bdActors.getFlow();
		
		this.comboBox = new JComboBox<Actor>();
		comboBox.addItem(ninio);
		comboBox.addItem(pelota);
		comboBox.addItem(piso);
		
		comboBox.setBounds(200, 155, 116, 23);
		northPanel.add(comboBox);
	}

	private void initializeNewSceneButton() {
		this.sceneButton = new JButton("Nueva Escena");
		sceneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScene(e);
			}
		});
		sceneButton.setBounds(10, 155, 134, 23);
		northPanel.add(sceneButton);
	}

	private void initializeCanvas() {
		this.canvas = new Canvas();
		this.canvas.setBackground(Color.GREEN);
		this.playPanel.add(canvas);
	}
	
	private void initializePlayPanel() {
		playPanel = new JPanel(new BorderLayout());
		playPanel.setPreferredSize(new Dimension(width-880, height-424));
		this.treePlayPanel.add(playPanel, BorderLayout.CENTER);
	}
	
	private void initializeCodeTextArea() {
		textArea.setText("Soy el nuevo editor de texto... ;D");
	}

	private void initializeTreePanel() {
		scroollPanel = new JScrollPane(this.treeScenes);
		scroollPanel.setPreferredSize(new Dimension(440, height-424));
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(model.getGameTitle());
		for (int i=0; i < model.cantScenes(); i++)
		{
			Scene scene = model.getSceneIn(i);
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
		DefaultTreeModel tree = new DefaultTreeModel(root);
		treeScenes.setModel(tree);
		this.treePlayPanel.add(scroollPanel, BorderLayout.WEST);
	}
	
	private void initializeEditorPanel() {
		editorPanel = new JPanel();
		editorPanel.setLayout(null);
		editorPanel.setPreferredSize(new Dimension(width-440, height-800));
		this.gameEditorPanel.add(editorPanel, BorderLayout.SOUTH);
		
		this.config = new JLabel("Panel de Configuraci\u00F3n:");
		config.setBounds(28, 22, 172, 23);
		editorPanel.add(config);
		
		this.nombre = new JLabel("Nombre: ");
		nombre.setBounds(28, 61, 72, 23);
		editorPanel.add(nombre);
		
		textField = new JTextField("un Nombre");
		textField.setBounds(110, 62, 86, 23);
		editorPanel.add(textField);
		textField.setColumns(10);
	}

	private void initializeTreePlayPanel() {
		treePlayPanel = new JPanel(new BorderLayout());
		treePlayPanel.setPreferredSize(new Dimension(width-440, height-424));
		this.gameEditorPanel.add(treePlayPanel, BorderLayout.CENTER);
	}

	private void initializeGameEditorPanel() {
		gameEditorPanel = new JPanel(new BorderLayout());
		gameEditorPanel.setPreferredSize(new Dimension(width-440, height-200));
		this.centerPanel.add(gameEditorPanel, BorderLayout.CENTER);
	}

	private void initializeTextPanel() {
		eastPanel = new JScrollPane(this.textArea);
		eastPanel.setPreferredSize(new Dimension(440, height-200));
		this.centerPanel.add(eastPanel, BorderLayout.EAST);
	}

	private void initializeCenterPanel() {
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(width, height-200));
		this.frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	private void initializeNorthPanel() {
		northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(width, 200));
		this.frame.getContentPane().add(northPanel, BorderLayout.NORTH);
	}

	private void initializeFrame(MainWindowModel model) {
		this.model = model;
		this.frame = new JFrame(this.title);
		this.frame.getContentPane().setLayout(new BorderLayout());
		this.frame.setSize(this.dimension);
		this.frame.setPreferredSize(this.dimension);
		this.frame.setMinimumSize(this.dimension);
		this.frame.setVisible(false);
		this.frame.setResizable(resizable);
		this.frame.setLocationRelativeTo(null);
		this.frame.addWindowListener(this);
		this.frame.addComponentListener(this);
		
	}

	protected void addScene(ActionEvent e) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
			if(lastNode.getLevel() == 0)
			{
				Scene newScene = new Scene("Escena" + this.idScene);
				this.model.addScene(newScene);
				modelNode.insertNodeInto(new DefaultMutableTreeNode(newScene), lastNode, modelNode.getChildCount(lastNode));
				this.idScene++;
			}
		}
	}
	
	protected void addActor(ActionEvent e) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel modelNode = (DefaultTreeModel) treeScenes.getModel();
			if(lastNode.getLevel() == 1)
			{
				Actor newActor = (Actor) comboBox.getSelectedItem();
				Scene scene = (Scene) lastNode.getUserObject();
				scene.addActor(newActor);
				modelNode.insertNodeInto( new DefaultMutableTreeNode(newActor), lastNode, modelNode.getChildCount(lastNode));
			}
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
	protected void setItemSelectComboBox(ActionEvent e) 
	{
			Actor actor = (Actor) comboBox.getSelectedItem();
			canvas.getGraphics().drawImage(actor.getImage(), actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight(), null); 
	}

	public void run() {	this.open(); }

	private void open() {
		if (!this.frame.isVisible()) {
			this.frame.setVisible(true);
		}
	}

	public void windowActivated(WindowEvent arg0) {	}

	public void windowClosed(WindowEvent arg0) { }

	public void windowClosing(WindowEvent arg0) { System.exit(0); }

	public void windowDeactivated(WindowEvent arg0) { }

	public void windowDeiconified(WindowEvent arg0) { }

	public void windowIconified(WindowEvent arg0) {	}

	public void windowOpened(WindowEvent arg0) { }

	public void componentHidden(ComponentEvent arg0) { }

	public void componentMoved(ComponentEvent arg0) { }

	public void componentResized(ComponentEvent arg0) {	}

	public void componentShown(ComponentEvent arg0) { }
}
