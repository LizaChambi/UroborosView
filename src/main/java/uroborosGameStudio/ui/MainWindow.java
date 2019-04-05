package uroborosGameStudio.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainWindow {

	private JFrame frmUroborosGameStudio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmUroborosGameStudio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUroborosGameStudio = new JFrame();
		frmUroborosGameStudio.setTitle("Uroboros Game Studio");
		frmUroborosGameStudio.setBounds(100, 100, 450, 300);
		frmUroborosGameStudio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
