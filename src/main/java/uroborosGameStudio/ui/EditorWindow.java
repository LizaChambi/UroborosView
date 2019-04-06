package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Canvas;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

public class EditorWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void OpenWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorWindow frame = new EditorWindow();
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
	public EditorWindow() {
		setTitle("Uroboros Game Studio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 864, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Nueva Escena");
		btnNewButton.setBounds(10, 27, 134, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nuevo Actor");
		btnNewButton_1.setBounds(154, 27, 116, 23);
		panel.add(btnNewButton_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(280, 27, 97, 23);
		panel.add(btnGuardar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 864, 467);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(122, 0, 410, 467);
		panel_1.add(canvas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(538, 0, 326, 467);
		panel_1.add(scrollPane);
		
		JTextPane txtpnSoyUnLindo = new JTextPane();
		txtpnSoyUnLindo.setText("Soy un lindo Editor de Texto");
		scrollPane.setViewportView(txtpnSoyUnLindo);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Name Proyect") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Scene01");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Scene02");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Scene03");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		tree.setBounds(0, 0, 116, 467);
		panel_1.add(tree);
	}
}
