package uroborosGameStudio.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import uroborosGameStudio.domain.Ball;
import uroborosGameStudio.domain.DummyActors;
import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.appModel.MainWindowModel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditorWindow extends JFrame {

	private JPanel contentPane;
	final MainWindowModel model;
	final DummyActors bdActors = new DummyActors();
	private JTree treeScenes = new JTree();
	private int idScene = 1;

	/**
	 * Launch the application.
	 */
	public static void OpenWindow(final MainWindowModel model) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorWindow frame = new EditorWindow(model);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditorWindow(MainWindowModel model) {
		this.model = model;
		setTitle("Uroboros Game Studio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel barraDeHerramientas = new JPanel();
		barraDeHerramientas.setBounds(10, 11, 864, 61);
		contentPane.add(barraDeHerramientas);
		barraDeHerramientas.setLayout(null);
		
		JButton btnNewButton = new JButton("Nueva Escena");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScene(e);
			}
		});
		btnNewButton.setBounds(10, 27, 134, 23);
		barraDeHerramientas.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nuevo Actor");
		btnNewButton_1.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent e) 
			{
				addActor(e);
			}
		});
		btnNewButton_1.setBounds(269, 27, 116, 23);
		barraDeHerramientas.add(btnNewButton_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(390, 27, 97, 23);
		barraDeHerramientas.add(btnGuardar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Niño", "Pelota", "Piso"}));
		comboBox.setBounds(154, 28, 105, 20);
		barraDeHerramientas.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 864, 467);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Canvas panelDeEjecucion = new Ball();
		panelDeEjecucion.setBounds(122, 0, 410, 467);
		panel_1.add(panelDeEjecucion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(538, 0, 326, 467);
		panel_1.add(scrollPane);
		
		JTextPane editorTxt = new JTextPane();
		editorTxt.setText("Soy un lindo Editor de Texto");
		scrollPane.setViewportView(editorTxt);
		
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
		treeScenes.setBounds(0, 0, 116, 467);
		panel_1.add(treeScenes);
	}

	protected void addScene(ActionEvent e) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel model = (DefaultTreeModel) treeScenes.getModel();
			if(lastNode.getLevel() == 0)
			{
				model.insertNodeInto(new DefaultMutableTreeNode(new Scene("Escena" + this.idScene)), lastNode, model.getChildCount(lastNode));
				this.idScene++;
			}
		}
	}
	
	protected void addActor(ActionEvent e) 
	{
		DefaultMutableTreeNode lastNode = (DefaultMutableTreeNode) treeScenes.getLastSelectedPathComponent();
		if (lastNode != null)
		{
			DefaultTreeModel model = (DefaultTreeModel) treeScenes.getModel();
			if(lastNode.getLevel() == 1)
			{
				model.insertNodeInto( new DefaultMutableTreeNode(bdActors.getKids()), lastNode, model.getChildCount(lastNode));
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
}
