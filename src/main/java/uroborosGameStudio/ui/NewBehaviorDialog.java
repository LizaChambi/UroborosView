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

public class NewBehaviorDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nameTextField;

	
	public NewBehaviorDialog(AdmBehaviors datosDePrueba) {
		setTitle("Nuevo comportamiento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel titlePanel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) titlePanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEADING);
			contentPanel.add(titlePanel, BorderLayout.NORTH);
			{
				JLabel lblTitle = new JLabel("Complete las siguientes propiedades del nuevo comportamiento:");
				lblTitle.setFont(new Font("Dialog", Font.PLAIN, 12));
				titlePanel.add(lblTitle);
			}
		}
		{
			JPanel configPanel = new JPanel();
			configPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Configuraci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
			contentPanel.add(configPanel);
			configPanel.setLayout(new BorderLayout(5, 5));
			{
				JPanel configNamePanel = new JPanel();
				configPanel.add(configNamePanel, BorderLayout.NORTH);
				configNamePanel.setLayout(new BorderLayout(5, 0));
				
				JPanel namePanel = new JPanel();
				configNamePanel.add(namePanel, BorderLayout.WEST);
				namePanel.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblName = new JLabel("Nombre:");
					lblName.setHorizontalAlignment(SwingConstants.CENTER);
					namePanel.add(lblName, BorderLayout.SOUTH);
				}
				
				JPanel textNamePanel = new JPanel();
				configNamePanel.add(textNamePanel, BorderLayout.CENTER);
				textNamePanel.setLayout(new GridLayout(0, 1, 0, 0));
				
				JLabel lblNewLabel = new JLabel("Panel de errores");
				lblNewLabel.setForeground(Color.RED);
				lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
				textNamePanel.add(lblNewLabel);
				
				nameTextField = new JTextField();
				textNamePanel.add(nameTextField);
				nameTextField.setColumns(10);
			}
			{
				JPanel configDescriptionPanel = new JPanel();
				configPanel.add(configDescriptionPanel, BorderLayout.CENTER);
				configDescriptionPanel.setLayout(new BorderLayout(5, 0));
				{
					JPanel descriptionPanel = new JPanel();
					FlowLayout flowLayout = (FlowLayout) descriptionPanel.getLayout();
					flowLayout.setVgap(0);
					flowLayout.setHgap(0);
					flowLayout.setAlignment(FlowLayout.LEADING);
					configDescriptionPanel.add(descriptionPanel, BorderLayout.WEST);
					{
						JLabel lblDescription = new JLabel("Descripción:");
						lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
						descriptionPanel.add(lblDescription);
					}
				}
				
				JScrollPane descriptionScrollPanel = new JScrollPane();
				configDescriptionPanel.add(descriptionScrollPanel, BorderLayout.NORTH);
				
				JTextArea textAreaDescription = new JTextArea();
				descriptionScrollPanel.setViewportView(textAreaDescription);
			}
			{
				JPanel globalPanel = new JPanel();
				configPanel.add(globalPanel, BorderLayout.SOUTH);
				FlowLayout flowLayout = (FlowLayout) globalPanel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEADING);
				{
					JLabel lblGlobal = new JLabel("Usar como un comportamiento global:");
					lblGlobal.setFont(new Font("Dialog", Font.PLAIN, 12));
					globalPanel.add(lblGlobal);
				}
				{
					JCheckBox chbxIsGlobal = new JCheckBox("");
					globalPanel.add(chbxIsGlobal);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
