package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.Actor;
import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.dummy.DummyActors;
import uroborosGameStudio.ui.componentListeners.SceneTreePanelTSL;
import uroborosGameStudio.ui.componentListeners.btnEditNameAL;

public class EditorWindow extends AbstractWindowFrame {

	MainWindowModel model;
	final DummyActors bdActors = new DummyActors();
	private int idScene = 1;
	
	private Canvas canvas = new Canvas();
	private Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
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
	private JTextField nameTF = new JTextField("");
	private JLabel config;
	private JLabel nombre;
	private JButton btnEditName;

	public void main() { run();	}

	public EditorWindow(MainWindowModel model) {
		super();
		this.model = model;
		this.initializeFrame();
		
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
		
		this.frame.pack();
	}
	
	private void initializeFrame() {
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
		this.frame.setPreferredSize(this.resolution);
		this.frame.setMinimumSize(new Dimension(800,600));
		this.frame.setLocationRelativeTo(null);
	}
	
	private void initializeSaveButton() {
		this.saveButton = new JButton("Guardar");
		saveButton.setBounds(500, 50, 97, 23);
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
		actorButton.setBounds(350, 50, 116, 23);
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
		
		comboBox.setBounds(200, 50, 116, 23);
		northPanel.add(comboBox);
	}

	private void initializeNewSceneButton() {
		this.sceneButton = new JButton("Nueva Escena");
		sceneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScene(e);
			}
		});
		sceneButton.setBounds(10, 50, 134, 23);
		northPanel.add(sceneButton);
	}

	private void initializeCanvas() {
		//this.canvas = new Canvas();
		this.canvas.setIgnoreRepaint(true);
		this.canvas.setFocusable(true);
		this.canvas.setFocusTraversalKeysEnabled(true);
		this.canvas.setBackground(Color.GREEN);
		this.playPanel.add(this.canvas);
	}
	
	private void initializePlayPanel() {
		playPanel = new JPanel(new BorderLayout());
		playPanel.setPreferredSize(new Dimension(resolution.width-880, resolution.height-424));
		this.treePlayPanel.add(playPanel, BorderLayout.CENTER);
	}
	
	private void initializeCodeTextArea() {
		textArea.setText("Editor de texto...");
	}

	private void initializeTreePanel() {
		scroollPanel = new JScrollPane(this.treeScenes);
		scroollPanel.setPreferredSize(new Dimension(300, 250));
		DefaultMutableTreeNode root = createTreeNode();
		DefaultTreeModel tree = new DefaultTreeModel(root);
		treeScenes.addTreeSelectionListener(new SceneTreePanelTSL(treeScenes,nameTF));
		treeScenes.setModel(tree);
		this.treePlayPanel.add(scroollPanel, BorderLayout.WEST);
	}
	
	private DefaultMutableTreeNode createTreeNode() 
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(model.getProject());
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
		return root;
	}

	private void initializeEditorPanel() {
		editorPanel = new JPanel();
		editorPanel.setLayout(null);
		editorPanel.setPreferredSize(new Dimension(800, 250));
		this.gameEditorPanel.add(editorPanel, BorderLayout.SOUTH);
		
		this.config = new JLabel("Panel de Configuraci\u00F3n:");
		config.setBounds(28, 22, 172, 23);
		editorPanel.add(config);
		
		this.nombre = new JLabel("Nombre: ");
		nombre.setBounds(28, 60, 72, 23);
		editorPanel.add(nombre);
		nameTF.setToolTipText("");
		
		nameTF.setBounds(110, 62, 100, 23);
		editorPanel.add(nameTF);
		nameTF.setColumns(10);
		
		this.btnEditName = new JButton("Editar");
		btnEditName.setBounds(230, 62, 100, 23);
		btnEditName.addActionListener(new btnEditNameAL(treeScenes,nameTF));
		editorPanel.add(btnEditName);
	}

	private void initializeTreePlayPanel() {
		treePlayPanel = new JPanel(new BorderLayout());
		treePlayPanel.setPreferredSize(new Dimension(200, 550));
		this.gameEditorPanel.add(treePlayPanel, BorderLayout.CENTER);
	}

	private void initializeGameEditorPanel() {
		gameEditorPanel = new JPanel(new BorderLayout());
		gameEditorPanel.setPreferredSize(new Dimension(resolution.width-440, resolution.height-200));
		this.centerPanel.add(gameEditorPanel, BorderLayout.CENTER);
	}

	private void initializeTextPanel() {
		eastPanel = new JScrollPane(this.textArea);
		eastPanel.setPreferredSize(new Dimension(440, resolution.height-200));
		this.centerPanel.add(eastPanel, BorderLayout.EAST);
	}

	private void initializeCenterPanel() {
		centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(resolution.width, resolution.height-200));
		this.frame.add(centerPanel, BorderLayout.CENTER);
	}

	private void initializeNorthPanel() {
		northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(resolution.width, 100) );
		this.frame.add(northPanel, BorderLayout.NORTH);
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
	
	protected void setItemSelectComboBox(ActionEvent e) 
	{
		Actor actor = (Actor) comboBox.getSelectedItem();
		canvas.getGraphics().drawImage(actor.getImage(), actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight(), null); 
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
