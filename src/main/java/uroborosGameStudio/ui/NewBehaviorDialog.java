package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uroborosGameStudio.domain.AdmBehaviors;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewBehaviorDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private AdmBehaviors datosDePrueba;
	private JPanel titlePanel;
	private JPanel configPanel;
	private JPanel configNamePanel;
	private JPanel textNamePanel;
	private JPanel configDescriptionPanel;
	private JPanel globalPanel;
	private JPanel buttonPane;
	
	public NewBehaviorDialog(AdmBehaviors datosDePrueba) 
	{
		this.inicializeDialog(datosDePrueba);
		this.titlePanel();
		this.configurationPanel();
		this.buttonPanel();
	}

	private void buttonPanel() 
	{
		this.inicializeButtonPanel();
		
		JButton okButton = new JButton("Crear");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
				
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		buttonPane.add(cancelButton);
	}

	private void inicializeButtonPanel() {
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}


	private void configurationPanel() 
	{
		this.inicializeConfigurationPanel();
		
		this.namePanel();
		this.descriptionPanel();
		this.globalPanel();
	}


	private void globalPanel() 
	{
		this.inicializeGlobalPanel();
		
		JCheckBox chbxIsGlobal = new JCheckBox("Asignar como un comportamiento global.");
		chbxIsGlobal.setFont(new Font("Dialog", Font.PLAIN, 12));
		globalPanel.add(chbxIsGlobal);
	}


	private void inicializeGlobalPanel() 
	{
		globalPanel = new JPanel();
		globalPanel.setBounds(12, 142, 431, 31);
		globalPanel.setFont(new Font("Dialog", Font.BOLD, 12));
		FlowLayout flowLayout = (FlowLayout) globalPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		configPanel.add(globalPanel);
	}

	private void descriptionPanel() 
	{
		this.inicializeDescriptionPanel();
		
		JLabel lblDescription = new JLabel("Ingrese una breve descripción del nuevo comportamiento:");
		lblDescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDescription.setHorizontalTextPosition(SwingConstants.LEADING);
		configDescriptionPanel.add(lblDescription, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		configDescriptionPanel.add(textArea);
	}

	private void inicializeDescriptionPanel() 
	{
		configDescriptionPanel = new JPanel();
		configDescriptionPanel.setBounds(12, 67, 424, 68);
		configPanel.add(configDescriptionPanel);
		configDescriptionPanel.setLayout(new BorderLayout(5, 5));
	}

	private void namePanel() 
	{
		this.inicializeNamePanel();
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		configNamePanel.add(lblName, BorderLayout.WEST);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 12));
			
		this.inicializeTextNamePanel();
			
		JLabel lblNewLabel = new JLabel("Panel de errores");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
		textNamePanel.add(lblNewLabel);
				
		nameTextField = new JTextField();
		textNamePanel.add(nameTextField);
		nameTextField.setColumns(10);
	}


	private void inicializeTextNamePanel() 
	{
		textNamePanel = new JPanel();
		configNamePanel.add(textNamePanel);
		textNamePanel.setLayout(new GridLayout(0, 1, 0, 0));
	}


	private void inicializeNamePanel() 
	{
		configNamePanel = new JPanel();
		configNamePanel.setBounds(12, 17, 424, 38);
		configPanel.add(configNamePanel);
		configNamePanel.setLayout(new BorderLayout(5, 0));
	}


	private void inicializeConfigurationPanel() 
	{
		configPanel = new JPanel();
		configPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Configuraci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		contentPanel.add(configPanel);
		configPanel.setLayout(null);
	}


	private void titlePanel() 
	{
		this.inicializeTitlePanel();
		this.title();
	}

	private void title() 
	{
		JLabel lblTitle = new JLabel("Complete las siguientes propiedades del nuevo comportamiento:");
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 12));
		titlePanel.add(lblTitle);
	}

	private void inicializeTitlePanel() 
	{
		titlePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) titlePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		contentPanel.add(titlePanel, BorderLayout.NORTH);
	}

	private void inicializeDialog(AdmBehaviors datosDePrueba) 
	{
		this.datosDePrueba = datosDePrueba;
		setTitle("Nuevo comportamiento");
		setBounds(100, 100, 450, 300);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setLayout(new BorderLayout(0, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}
}
