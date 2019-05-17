package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uroborosGameStudio.ui.componentListeners.OpenProjectActionListener;

public class MainWindow extends AbstractWindowFrame {

	private JPanel centerPanel;
	private JButton createButton;
	private JButton openButton;
	private JLabel titleL;
	private JLabel iconL;

	public MainWindow() {
		super();
		this.setResolution(new Dimension(500, 350));
		
		this.initializeFrame();
		this.initializeCenterPanel();
		
		this.initializeCreateProyectButton();
		this.initializaOpenProyectButton();
		this.initializeTitleLabel();
		this.initializeImgIcon();
		
		this.frame.pack();
	}

	private void initializeImgIcon() {
		this.iconL = new JLabel(new ImageIcon("images/icon-logo-resize.png"));
		iconL.setBounds(215, 40, 70, 70);
		centerPanel.add(this.iconL);
	}

	private void initializeTitleLabel() {
		this.titleL = new JLabel("Bienvenidos a Uroboros Game Studio");
		titleL.setHorizontalAlignment(SwingConstants.CENTER);
		titleL.setBounds(50, 115, 400, 30);
		titleL.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		centerPanel.add(this.titleL);
	}

	private void initializaOpenProyectButton() {
		this.openButton = new JButton("Abrir proyecto");
		openButton.setBounds(175, 220, 150, 23);
		openButton.addActionListener(new OpenProjectActionListener(model, frame, centerPanel));
		centerPanel.add(this.openButton);
	}

	private void initializeCreateProyectButton() {
		this.createButton = new JButton("Crear nuevo proyecto");
		createButton.setBounds(150, 180, 200, 23);
		this.createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.createNewProyect();
				new EditorWindow().run();
				frame.dispose();
			}
		});
		centerPanel.setLayout(null);
		centerPanel.add(this.createButton);
	}

	private void initializeCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setPreferredSize(new Dimension(500, 350));
		centerPanel.setBackground(Color.white);
		this.frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	private void initializeFrame() {
		Dimension dim = new Dimension(500, 350);
		this.frame.setSize(dim);
		this.frame.setPreferredSize(dim);
		this.frame.setMinimumSize(dim);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
	}
}
