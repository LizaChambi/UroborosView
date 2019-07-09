package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import uroborosGameStudio.ui.componentListeners.CreateNewProjectAL;
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
		
		this.frame.setTitle("Bienvenidos a Uroboros Game Studio");
		this.initializeFrame();
		this.initializeCenterPanel();
		
		this.initializeCreateProjectButton();
		this.initializaOpenProjectButton();
		this.initializeTitleLabel();
		this.initializeImgIcon();
		
		this.frame.pack();
	}

	private void initializeImgIcon() {
		this.iconL = new JLabel(new ImageIcon("images/icon-logo-resize.png"));
		iconL.setBounds(100, 11, 300, 300);
		centerPanel.add(this.iconL);
	}

	private void initializeTitleLabel() {
		this.titleL = new JLabel("Uroboros");
		titleL.setForeground(Color.RED);
		titleL.setHorizontalAlignment(SwingConstants.CENTER);
		titleL.setBounds(50, 108, 400, 30);
		titleL.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		JLabel titleL2 = new JLabel("Game");
		titleL2.setForeground(Color.RED);
		titleL2.setHorizontalAlignment(SwingConstants.CENTER);
		titleL2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		titleL2.setBounds(201, 149, 97, 30);
		centerPanel.add(titleL2);
		
		JLabel lblStudio = new JLabel("Studio");
		lblStudio.setForeground(Color.RED);
		lblStudio.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblStudio.setBounds(201, 190, 97, 30);
		centerPanel.add(lblStudio);
		
		centerPanel.add(this.titleL);
	}

	private void initializaOpenProjectButton() {
		this.openButton = new JButton("Abrir proyecto", new ImageIcon("images/open-folder-icon.png"));
		openButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		openButton.setBounds(280, 338, 170, 50);
		openButton.addActionListener(new OpenProjectActionListener(model, frame, centerPanel));
		centerPanel.add(this.openButton);
	}

	private void initializeCreateProjectButton() {
		this.createButton = new JButton("Nuevo proyecto", new ImageIcon("images/folder-new-icon.png"));
		createButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		createButton.setBounds(45, 338, 190, 50);
		this.createButton.addActionListener(new CreateNewProjectAL(frame, model));
		centerPanel.setLayout(null);
		centerPanel.add(this.createButton);
	}

	private void initializeCenterPanel() {
		centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setPreferredSize(new Dimension(500, 400));
		centerPanel.setBackground(Color.WHITE);
		this.frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	private void initializeFrame() {
		Dimension dim = new Dimension(500, 450);
		this.frame.setSize(dim);
		this.frame.setPreferredSize(dim);
		this.frame.setMinimumSize(dim);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
	}
}
