package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class GlobalBehaviorDialog extends JDialog 
{
	private final JPanel contentPanel = new JPanel();
	private JScrollPane globalBehaviorScrollPanel;
	private JPanel buttonsPanel;
	private JPanel behaviorScrollPanel;
	private JPanel buttonPane;

	public GlobalBehaviorDialog() 
	{
		this.inicializeDialog();
		this.scrollListGlobalBehavior();
		this.buttonPanel();
		this.scrollBehaviors();
		this.descriptionBehaviorPanel();
		this.buttons();
	}

	private void buttons() 
	{
		this.inicializedCompletionButtons();
		
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		buttonPane.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}});
		buttonPane.add(cancelButton);
	}

	private void inicializedCompletionButtons() 
	{
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	private void descriptionBehaviorPanel() 
	{
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		descriptionPanel.setBounds(5, 360, 588, 64);
		FlowLayout flowLayout = (FlowLayout) descriptionPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		contentPanel.add(descriptionPanel);
		
		Label lblDescription = new Label("Descripción del comportamiento global");
		descriptionPanel.add(lblDescription);
		
	}

	private void scrollBehaviors() 
	{
		this.inicializeScrollBehaviorPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		JList<Object> list = new JList<Object>();
		scrollPane.setViewportView(list);
		behaviorScrollPanel.add(scrollPane);
		
	}

	private void inicializeScrollBehaviorPanel() 
	{
		behaviorScrollPanel = new JPanel();
		behaviorScrollPanel.setBounds(358, 5, 235, 351);
		behaviorScrollPanel.setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.add(behaviorScrollPanel);
	}

	private void buttonPanel() 
	{
		this.inicializedButtonPanel();
		
		JButton btnAddBehavior = new JButton("Agregar");
		buttonsPanel.add(btnAddBehavior);
			
		JButton btnRemoveBehavior = new JButton("Sacar");
		buttonsPanel.add(btnRemoveBehavior);
	}

	private void inicializedButtonPanel() 
	{
		buttonsPanel = new JPanel();
		buttonsPanel.setBounds(241, 5, 117, 351);
		contentPanel.add(buttonsPanel);
	}

	private void scrollListGlobalBehavior() 
	{
		this.inicializeScrollGlobalBehaviorPanel();
		JList<Object> listGlobalBehavior = new JList<Object>();
		this.globalBehaviorScrollPanel.setViewportView(listGlobalBehavior);
	}

	private void inicializeScrollGlobalBehaviorPanel() 
	{
		globalBehaviorScrollPanel = new JScrollPane();
		globalBehaviorScrollPanel.setBounds(5, 5, 235, 351);
		contentPanel.add(globalBehaviorScrollPanel);
	}

	private void inicializeDialog() {
		setTitle("Comportamientos globales");
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	}
}
