package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uroborosGameStudio.ui.components.ButtonUGS;
import uroborosGameStudio.ui.components.SimpleLabelUGS;

public class NewActorDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel globalPanel = new JPanel();
	private JPanel headerPanel;
	private JPanel propertiesPanel;
	private JPanel buttonPanel;

	public NewActorDialog() 
	{
		initializedDialog();
		initializedHeaderPanel();
		titleLabel();
		
		initializedPropertiesPanel();
		properties();
		
		initializedButtonPanel();
		buttons();
	}

	private void properties() 
	{
		
	}

	private void buttons() 
	{
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		{
			JButton okButton = new JButton("Crear");
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
		globalPanel.add(propertiesPanel, BorderLayout.CENTER);
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

	private void initializedDialog() {
		setTitle("Nuevo Actor");
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		globalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout(new BorderLayout(0, 0));
	}

}
