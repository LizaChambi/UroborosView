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

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class MainWindow extends AbstractWindowFrame {

	private JPanel centerPanel;
	private JButton createButton;
	private JButton openButton;
	private JLabel titleL;
	private JLabel iconL;

	public void main() { run(); }

	public MainWindow(MainWindowModel model) {
		super(model);
		this.setWidth(500);
		this.setHeight(350);
		this.setResolution(new Dimension(width, height));
		
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
		iconL.setBounds(219, 60, 60, 60);
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
				new EditorWindow(getModelObject()).main();
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
		this.frame.setPreferredSize(this.resolution);
		this.frame.setMinimumSize(this.resolution);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
	}

}
