package uroborosGameStudio.ui;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.Actor;
import uroborosGameStudio.domain.ExecutionCanvas;
import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.dummy.DummyActors;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class EditorWindow implements Runnable, WindowListener, ComponentListener {

	private JPanel contentPane;
	MainWindowModel model;
	final DummyActors bdActors = new DummyActors();
	private JTree treeScenes = new JTree();
	private int idScene = 1;
	JComboBox<Actor> comboBox = new JComboBox<Actor>();
	Canvas canvas = new ExecutionCanvas();
	JTextPane txtName = new JTextPane();
	private JFrame frame;
	private String title = "Uroboros Game Studio";
	private Integer width = 1024;
	private Integer height = 1280;
	private Dimension dimension = new Dimension(width, height);
	private boolean resizable = true;

	public static void OpenWindow(final MainWindowModel model) {
		
		new EditorWindow(model).run();
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try 
//				{
//					EditorWindow frame = new EditorWindow(model);
//					frame.setVisible(true);
//				} 
//				catch (Exception e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		});
	}

	public EditorWindow(MainWindowModel model) {
		this.initializeFrame();
//		this.model = model;
//		setTitle("Uroboros Game Studio");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 900, 600);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel toolbar = new JPanel();
//		toolbar.setBounds(10, 11, 864, 61);
//		contentPane.add(toolbar);
//		toolbar.setLayout(null);
//		
//		JButton btnNewScene = new JButton("Nueva Escena");
//		btnNewScene.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				addScene(e);
//			}
//		});
//		btnNewScene.setBounds(10, 27, 134, 23);
//		toolbar.add(btnNewScene);
//		
//		Actor ninio = bdActors.getKids();
//		Actor pelota = bdActors.getBall();
//		Actor piso = bdActors.getFlow();
// 		
//		comboBox.setModel(new DefaultComboBoxModel<Actor>());
//		comboBox.addItem(ninio);
//		comboBox.addItem(pelota);
//		comboBox.addItem(piso);
//		comboBox.setBounds(154, 28, 105, 20);
//		toolbar.add(comboBox);
//		
//		JPanel mainPanel = new JPanel();
//		JButton btnNewActor = new JButton("Nuevo Actor");
//		btnNewActor.addActionListener(new ActionListener() 
//		{	
//			public void actionPerformed(ActionEvent e) 
//			{
//				addActor(e);
//				setItemSelectComboBox(e);
//			}
//		});
//		btnNewActor.setBounds(269, 27, 116, 23);
//		toolbar.add(btnNewActor);
//		
//		JScrollPane scrollDirectoryPane = new JScrollPane();
//		scrollDirectoryPane.setBounds(0, 0, 174, 467);
//		mainPanel.add(scrollDirectoryPane);
//		treeScenes.setBounds(0, 0, 116, 467);
//		
//		JButton btnSave = new JButton("Guardar");
//		btnSave.setEnabled(false);
//		btnSave.setBounds(390, 27, 97, 23);
//		toolbar.add(btnSave);
//		
//		mainPanel.setBounds(10, 83, 864, 467);
//		contentPane.add(mainPanel);
//		mainPanel.setLayout(null);
//				
//		JPanel centralPanel = new JPanel();
//		centralPanel.setBounds(186, 0, 416, 455);
//		mainPanel.add(centralPanel);
//		
//		canvas.setBounds(180, 0, 409, 400);
//		
//		JLabel lblNewLabel = new JLabel("Configuración:");
//		
//		JLabel lblNombre = new JLabel("Nombre:");
//		
//		JTextPane txtName = new JTextPane();
//		txtName.setText("name");
//		GroupLayout gl_centralPanel = new GroupLayout(centralPanel);
//		gl_centralPanel.setHorizontalGroup(
//			gl_centralPanel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_centralPanel.createSequentialGroup()
//					.addGroup(gl_centralPanel.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_centralPanel.createSequentialGroup()
//							.addContainerGap()
//							.addGroup(gl_centralPanel.createParallelGroup(Alignment.LEADING)
//								.addGroup(gl_centralPanel.createSequentialGroup()
//									.addGap(12)
//									.addComponent(lblNombre)
//									.addPreferredGap(ComponentPlacement.UNRELATED)
//									.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
//								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
//						.addGroup(gl_centralPanel.createSequentialGroup()
//							.addGap(4)
//							.addComponent(canvas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
//					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//		);
//		gl_centralPanel.setVerticalGroup(
//			gl_centralPanel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_centralPanel.createSequentialGroup()
//					.addGap(5)
//					.addComponent(canvas, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.UNRELATED)
//					.addComponent(lblNewLabel)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(gl_centralPanel.createParallelGroup(Alignment.TRAILING)
//						.addComponent(lblNombre)
//						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addContainerGap(90, Short.MAX_VALUE))
//		);
//		centralPanel.setLayout(gl_centralPanel);
//		
//		JScrollPane scrollEditorText = new JScrollPane();
//		scrollEditorText.setBounds(614, 0, 250, 467);
//		mainPanel.add(scrollEditorText);
//		
//		JTextPane editorTxt = new JTextPane();
//		editorTxt.setText("Editor de Texto");
//		scrollEditorText.setViewportView(editorTxt);
//		
//		DefaultMutableTreeNode root = new DefaultMutableTreeNode(model.getGameTitle());
//		for (int i=0; i < model.cantScenes(); i++)
//		{
//			Scene scene = model.getSceneIn(i);
//			DefaultMutableTreeNode child1 = new DefaultMutableTreeNode();
//			child1.setUserObject(scene);
//			for (int si=0; si<scene.cantActors();si++)
//			{
//				DefaultMutableTreeNode child11 = new DefaultMutableTreeNode();
//				child11.setUserObject(scene.getActorIn(si));
//				child1.add(child11);
//			}
//			root.add(child1);
//		}
//		
//		DefaultTreeModel tree = new DefaultTreeModel(root);
//		treeScenes.setModel(tree);
//		treeScenes.setBounds(0, 0, 174, 467);
//		scrollDirectoryPane.setViewportView(treeScenes);
	}

	private void initializeFrame() {
		this.frame = new JFrame(this.title);
		this.frame.setLayout(new BorderLayout());
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

	public void run() {
		this.open();
	}

	private void open() {
		if (!this.frame.isVisible()) {
			this.frame.setVisible(true);
		}
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
