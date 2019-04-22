package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class MainWindow implements Runnable, WindowListener, ComponentListener {

	JFrame frame;
	String title = "Uroboros Game Studio";

	Integer width = 500;
	Integer height = 350;
	Dimension dimension = new Dimension(width, height);
	Boolean resizable = true;
	
	private JPanel centerPanel;
	private JButton createButton;
	private JButton openButton;
	private JLabel titleL;
	private JLabel iconL;
	
	private MainWindowModel model = new MainWindowModel();

	public static void main(String[] args) { new MainWindow().run(); }

	public void run() {	this.open(); }

	private void open() {
		if (!this.frame.isVisible()) {
			this.frame.setVisible(true);
		}
	}

	public MainWindow() {
		this.initializeFrame();
		this.initializeCenterPanel();
		
		this.initializeCreateProyectButton();
		this.initializaOpenProyectButton();
		this.initializeTitleLabel();
		this.initializeImgIcon();
		
		this.frame.pack();
	}

	private void initializeImgIcon() {
		this.iconL = new JLabel(new ImageIcon("images/icon-logo-resize.jpg"));
		iconL.setBounds(219, 60, 50, 50);
		centerPanel.add(this.iconL);
	}

	private void initializeTitleLabel() {
		this.titleL = new JLabel("Bienvenidos a Uroboros Game Studio");
		titleL.setBounds(59, 121, 383, 30);
		titleL.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		centerPanel.add(this.titleL);
	}

	private void initializaOpenProyectButton() {
		this.openButton = new JButton("Abrir proyecto");
		openButton.setBounds(261, 172, 129, 23);
		this.openButton.setEnabled(false);
		centerPanel.add(this.openButton);
	}

	private void initializeCreateProyectButton() {
		this.createButton = new JButton("Crear proyecto nuevo");
		createButton.setBounds(69, 172, 162, 23);
		this.createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.createNewProyect();
				EditorWindow editor = new EditorWindow(model);
				editor.OpenWindow(model);
				frame.dispose();
			}
		});
		centerPanel.add(this.createButton);
	}

	private void initializeCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setPreferredSize(new Dimension(120, 170));
		centerPanel.setBackground(Color.white);
		this.frame.add(centerPanel, BorderLayout.CENTER);
	}

	private void initializeFrame() {
		this.frame = new JFrame(this.title);
		this.frame.setLayout(new BorderLayout());
//		this.frame.setSize(this.dimension);
		this.frame.setPreferredSize(this.dimension);
		this.frame.setMinimumSize(this.dimension);
		this.frame.setVisible(false);
		this.frame.setResizable(false); // default true
		this.frame.setLocationRelativeTo(null);
		this.frame.addWindowListener(this);
		this.frame.addComponentListener(this);
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

	public void componentResized(ComponentEvent arg0) { }

	public void componentShown(ComponentEvent arg0) { }
}
