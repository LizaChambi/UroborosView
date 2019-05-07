package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewActorDialog extends JDialog {

	private final JPanel globalPanel = new JPanel();

	public NewActorDialog() 
	{
		setTitle("Nuevo Actor");
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		globalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel errorPanel = new JPanel();
			FlowLayout fl_errorPanel = (FlowLayout) errorPanel.getLayout();
			fl_errorPanel.setAlignment(FlowLayout.LEFT);
			globalPanel.add(errorPanel, BorderLayout.NORTH);
			{
				Label tittleLabel = new Label("Complete las siguientes propiedades:");
				errorPanel.add(tittleLabel);
			}
		}
		{
			JPanel propertiesPanel = new JPanel();
			propertiesPanel.setBorder(BorderFactory.createTitledBorder("Propiedades"));
			globalPanel.add(propertiesPanel, BorderLayout.CENTER);
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.setActionCommand("OK");
				buttonPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPanel.add(cancelButton);
			}
		}
	}

}
