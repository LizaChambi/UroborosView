package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.components.ButtonUGS;
import uroborosGameStudio.ui.components.SimpleLabelUGS;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		this.model = model;
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
		
		initializedPanelName();
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(5, 7, 60, 15);
		panelName.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				String text = textFieldName.getText();
				if (text.isEmpty())
				{
					System.out.println("Por favor, ingrese un nombre para el actor.");
					okButton.setEnabled(false);
				}
				else
				{
					String letter = text.substring(0, 1);
					if (! letter.contains(letter.toUpperCase()) )
					{
						System.out.println("Letra inicial: " + letter);
						System.out.println("Debe ingresar un nombre con letra inicial en mayuscula.");
						okButton.setEnabled(false);
					}
					else
					{
						if (model.validName(textFieldName.getText()))
						{
							System.out.println("El nombre del actor ya está en uso.");
							okButton.setEnabled(false);
						}
						else
						{
							System.out.println("El nombre: " + text + " es válido.");
							okButton.setEnabled(true);
						}
					}
					
				}
			}
		});
		textFieldName.setBounds(70, 5, 346, 19);
		textFieldName.setColumns(10);
		panelName.add(textFieldName);
		
		initializedPanelImage();
			
		lblImage = new JLabel("Imágen:");
		lblImage.setBounds(5, 10, 57, 15);
		propertiesPanel.add(panelImage);
		panelImage.add(lblImage);
		
		textFieldImagen = new JTextField();
		textFieldImagen.setBounds(67, 8, 274, 19);
		textFieldImagen.setColumns(10);
		panelImage.add(textFieldImagen);
		
		btnOpenImage = new JButton("Abrir...");
		btnOpenImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFile = new JFileChooser();
				jFile.setAcceptAllFileFilterUsed(false);
				FileFilter filterPNG = new FileNameExtensionFilter("PNG (.png)", "png");
				FileFilter filterJPEG = new FileNameExtensionFilter("JPEG (.jpeg/.jpg)", "jpeg", "jpg");
				jFile.addChoosableFileFilter(filterPNG);
				jFile.addChoosableFileFilter(filterJPEG);
				jFile.showOpenDialog(panelImage);
				File archivo = jFile.getSelectedFile();
				if (archivo != null)
				{
					textFieldImagen.setText(archivo.getAbsolutePath());
				}
			}
		});
		btnOpenImage.setBounds(341, 5, 75, 25);
		btnOpenImage.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelImage.setLayout(null);
		
		panelImage.add(btnOpenImage);
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

	private void initializedDialog() {
		setTitle("Nuevo Actor");
		setBounds(100, 100, 450, 500);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		globalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout(new BorderLayout(0, 0));
	}
}
