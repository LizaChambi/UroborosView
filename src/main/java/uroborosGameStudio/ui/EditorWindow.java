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
import uroborosGameStudio.domain.Scene;
import uroborosGameStudio.domain.appModel.MainWindowModel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class EditorWindow extends JFrame {

	private JPanel contentPane;
	private MainWindowModel model;

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
		btnNewButton.setBounds(10, 27, 134, 23);
		barraDeHerramientas.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nuevo Actor");
		btnNewButton_1.setBounds(154, 27, 116, 23);
		barraDeHerramientas.add(btnNewButton_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(280, 27, 97, 23);
		barraDeHerramientas.add(btnGuardar);
		
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
		
		JTree treeScenes = new JTree();
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(model.getGameTitle());
		
		for (int i=0; i < model.cantScenes(); i++)
		{
			Scene scene = model.getSceneIn(i);
			DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(scene.getName());
			for (int si=0; si<scene.cantActors();si++)
			{
				DefaultMutableTreeNode child11 = new DefaultMutableTreeNode(scene.getActorIn(si).getName());
				child1.add(child11);
			}
			root.add(child1);
		}
		
		DefaultTreeModel tree = new DefaultTreeModel(root);
		treeScenes.setModel(tree);
		treeScenes.setBounds(0, 0, 116, 467);
		panel_1.add(treeScenes);
	}
}
