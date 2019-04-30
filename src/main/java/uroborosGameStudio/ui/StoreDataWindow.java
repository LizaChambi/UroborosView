package uroborosGameStudio.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTree;

import uroborosGameStudio.domain.GameData;
import uroborosGameStudio.domain.Proyect;

import java.awt.TextArea;
import java.awt.Canvas;
import java.awt.Color;

public class MainWindow2 {

	private JFrame frame;
	private TextArea textArea;
	private Canvas canvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow2 window = new MainWindow2();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void escrituraLectura() 
	{
		GameData game = new GameData("JueguitoNuevo");
		Proyect p = new Proyect();
		p.escritura(game);
		game.getScenes().get(0).setName("cambieDeNombre");
		p.lectura();
		p.escritura(game);
		p.lectura();
	}
	
	/**
	 * Create the application.
	 */
	public MainWindow2() {
		initialize();
		escrituraLectura();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		frame.getContentPane().add(tree, BorderLayout.WEST);
		
		textArea = new TextArea();
		frame.getContentPane().add(textArea, BorderLayout.EAST);
		
		canvas = new Canvas();
		canvas.setBackground(Color.GREEN);
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
	}

}
