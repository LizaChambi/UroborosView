package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.componentListeners.ActorNameAdapterListener;
import uroborosGameStudio.ui.componentListeners.BtnOpenImageActionListener;
import uroborosGameStudio.ui.components.ButtonUGS;
import uroborosGameStudio.ui.components.SimpleLabelUGS;

public class NewActorDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel globalPanel = new JPanel();
	private MainWindowModel model;
	private JPanel headerPanel;
	private JPanel propertiesPanel;
	private JPanel buttonPanel;
	private JPanel panelName;
	private JTextField textFieldName;
	private JPanel panelImage;
	private JLabel lblImage;
	private JTextField textFieldImagen;
	private JButton btnOpenImage;
	private JButton okButton;

	public NewActorDialog(MainWindowModel model) 
	{
		initializedDialog(model);
		initializedHeaderPanel();
		titleLabel();
		
		initializedPropertiesPanel();
		initializedButtonPanel();
		
		buttons();
		properties();
	}

	private void properties() 
	{
		propertyName();
		propertyImage();
	}

	private void propertyImage() 
	{
		initializedPanelImage();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		lblImage = new JLabel("Imágen:");
		lblImage.setBounds(5, 10, 57, 15);
		propertiesPanel.add(panelImage);
		panelImage.add(lblImage);
		
		textFieldImagen = new JTextField();
		textFieldImagen.setBounds(67, 8, 274, 19);
		textFieldImagen.setColumns(10);
		panelImage.add(textFieldImagen);
		
		btnOpenImage = new JButton("Abrir...");
		btnOpenImage.addActionListener(new BtnOpenImageActionListener(textFieldImagen, panelImage));
		btnOpenImage.setBounds(341, 5, 75, 25);
		btnOpenImage.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelImage.setLayout(null);
		panelImage.add(btnOpenImage);
	}

	private void propertyName() 
	{
		initializedPanelName();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(5, 7, 60, 15);
		panelName.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new ActorNameAdapterListener(textFieldName, okButton, model));
		textFieldName.setBounds(70, 5, 346, 19);
		textFieldName.setColumns(10);
		panelName.add(textFieldName);
	}

	private void buttons() 
	{
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		{
			okButton = new JButton("Crear");
			buttonPanel.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		
		new ButtonUGS("Cancel", new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		}, buttonPanel);
		
	}

	private void initializedButtonPanel() 
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	
	private void initializedPropertiesPanel() 
	{
		propertiesPanel = new JPanel();
		propertiesPanel.setBorder(BorderFactory.createTitledBorder("Propiedades"));
		propertiesPanel.setLayout(null);
		globalPanel.add(propertiesPanel);
	}

	private void initializedPanelImage() {
		panelImage = new JPanel();
		panelImage.setBounds(5, 44, 428, 30);
		propertiesPanel.add(panelImage);
	}

	private void initializedPanelName() {
		panelName = new JPanel();
		panelName.setBounds(5, 17, 428, 30);
		panelName.setLayout(null);
		propertiesPanel.add(panelName);
	}

	private void initializedHeaderPanel() 
	{
		headerPanel = new JPanel();
		FlowLayout fl_errorPanel = (FlowLayout) headerPanel.getLayout();
		fl_errorPanel.setAlignment(FlowLayout.LEFT);
		globalPanel.add(headerPanel, BorderLayout.NORTH);
	}

	private void titleLabel() 
	{
		new SimpleLabelUGS("Complete las siguientes propiedades:", headerPanel);
	}

	private void initializedDialog(MainWindowModel model) 
	{
		this.model = model;
		setTitle("Nuevo Actor");
		setBounds(100, 100, 450, 500);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		globalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout(new BorderLayout(0, 0));
	}
}
