package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.componentListeners.BehaviorNameAdapterListener;
import uroborosGameStudio.ui.componentListeners.BtnAddBehaviorActionListener;

public class NewBehaviorDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;
	private JPanel titlePanel;
	private JPanel configPanel;
	private JPanel configNamePanel;
	private JPanel textNamePanel;
	private JPanel configDescriptionPanel;
	private JPanel globalPanel;
	private JPanel buttonPane;
	private JTextArea textDescription;
	private JCheckBox chbxIsGlobal;
	private JTable table;
	private JButton okButton = new JButton("Crear");
	private JLabel lblError;
	private JTree treeScenes;
	private Canvas canvas;
	private MainWindowModel model;
	
	public NewBehaviorDialog(MainWindowModel model, JTree treeScenes, Canvas canvas, JTable table) 
	{
		this.inicializeDialog(model, treeScenes, canvas, table);
		this.titlePanel();
		this.configurationPanel();
		this.buttonPanel();
	}

	private void buttonPanel() 
	{
		this.inicializeButtonPanel();
		
		okButton.addActionListener(new BtnAddBehaviorActionListener(treeScenes, canvas, table, nameTextField, textDescription, chbxIsGlobal, this));
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
		
		chbxIsGlobal = new JCheckBox("Asignar como un comportamiento global.");
		chbxIsGlobal.setFont(new Font("Dialog", Font.PLAIN, 12));
		globalPanel.add(chbxIsGlobal);
	}


	private void inicializeGlobalPanel() 
	{
		globalPanel = new JPanel();
		globalPanel.setBounds(12, 142, 424, 31);
		globalPanel.setFont(new Font("Dialog", Font.BOLD, 12));
		FlowLayout flowLayout = (FlowLayout) globalPanel.getLayout();
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		configPanel.add(globalPanel);
	}

	private void descriptionPanel() 
	{
		this.inicializeDescriptionPanel();
		
		JLabel lblDescription = new JLabel("Ingrese una breve descripción del nuevo comportamiento:");
		lblDescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDescription.setHorizontalTextPosition(SwingConstants.LEADING);
		configDescriptionPanel.add(lblDescription, BorderLayout.NORTH);
		
		textDescription = new JTextArea();
		textDescription.setLineWrap(true);
		configDescriptionPanel.add(textDescription);
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
		lblName.setFont(new Font("Dialog", Font.PLAIN, 12));
		configNamePanel.add(lblName, BorderLayout.WEST);
			
		this.inicializeTextNamePanel();
			
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Dialog", Font.PLAIN, 11));
		textNamePanel.add(lblError);
				
		nameTextField = new JTextField();
		
		nameTextField.addKeyListener(new BehaviorNameAdapterListener(model, okButton, lblError, nameTextField));
		nameTextField.setColumns(10);
		textNamePanel.add(nameTextField);
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

	private void inicializeDialog(MainWindowModel model, JTree treeScenes, Canvas canvas, JTable table) 
	{
		this.model = model;
		this.table = table;
		this.treeScenes = treeScenes;
		this.canvas = canvas;
		setTitle("Nuevo comportamiento");
		setBounds(100, 100, 450, 300);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setLayout(new BorderLayout(0, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}
}
