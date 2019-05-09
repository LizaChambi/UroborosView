package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.componentListeners.ActorNameAdapterListener;
import uroborosGameStudio.ui.componentListeners.BtnAddActorActionListener;
import uroborosGameStudio.ui.componentListeners.BtnOpenImageActionListener;
import uroborosGameStudio.ui.components.ButtonUGS;

public class NewActorDialog extends JDialog 
{
	private static final long serialVersionUID = 1L;
	private final JPanel globalPanel = new JPanel();
	private MainWindowModel model;
	private Canvas canvas;
	private JTree treeScenes;
	private JPanel headerPanel;
	private JPanel propertiesPanel;
	private JPanel buttonPanel;
	private JPanel panelName;
	private JTextField textFieldName;
	private JPanel panelImage;
	private JLabel lblImage;
	private JTextField textFieldImagen;
	private JButton btnOpenImage;
	private JButton okButton = new JButton("Crear");
	private JLabel lblError;
	private JPanel panelFrames = new JPanel();
	private JLabel lblAncho;
	private JTextField textFieldWidth;
	private JLabel lblHigh;
	private JTextField textFieldHeight;
	private JLabel lblNewLabel;
	private JCheckBox cbxHabilitarFrames;
	private JLabel lblFrames;
	private JPanel panelNumFrames;
	private JTextField textFieldNumFrames;
	private JPanel panelTitleFrame;
	private JPanel panelDimensionFrame;
	private Boolean enableNewActor = false;

	public NewActorDialog(MainWindowModel model, JTree treeScenes, Canvas canvas) 
	{
		initializedDialog(model, treeScenes, canvas);
		initializedHeaderPanel();
		titleLabel();
		
		initializedPropertiesPanel();
		initializedButtonPanel();
		
		properties();
		buttons();
	}

	private void properties() 
	{
		propertyName();
		propertyImage();
		propertyFrames();
	}

	private void propertyImage() 
	{
		initializedPanelImage();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		lblImage = new JLabel("Imágen:");
		lblImage.setBounds(5, 10, 57, 15);
		propertiesPanel.add(panelImage);
		panelImage.add(lblImage);
		
		textFieldImagen = new JTextField("");
		textFieldImagen.setEditable(false);
		textFieldImagen.setBounds(71, 8, 269, 19);
		textFieldImagen.setColumns(10);
		panelImage.add(textFieldImagen);
		
		btnOpenImage = new JButton("Abrir...");
		btnOpenImage.addActionListener(new BtnOpenImageActionListener(textFieldImagen, panelImage, okButton));
		btnOpenImage.setBounds(341, 5, 75, 25);
		btnOpenImage.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelImage.setLayout(null);
		panelImage.add(btnOpenImage);
		
		cbxHabilitarFrames = new JCheckBox("Habilitar fotogramas");
		// PARA HABILITAR ESTO, "panelFrame" TIENE QUE INICIALIZARSE ANTES
		//cbxHabilitarFrames.addItemListener(new CboxEnableFrameListener(cbxHabilitarFrames, panelFrames));
		
		cbxHabilitarFrames.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbxHabilitarFrames.isSelected())
				{
					panelFrames.setVisible(true);
				}
				else
				{
					panelFrames.setVisible(false);
				}
			}
		});
		cbxHabilitarFrames.setBounds(0, 36, 420, 23);
		panelImage.add(cbxHabilitarFrames);
	}

	private void propertyFrames() 
	{
		inicializedPanelFrames();
		numberFrames();
		titleDimensionFrames();
		dimensionFrames();
	}

	private void dimensionFrames() 
	{
		inicializedDimensionFrame();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(5, 7, 48, 15);
		panelDimensionFrame.add(lblAncho);
		
		textFieldWidth = new JTextField("");
		textFieldWidth.setBounds(58, 5, 135, 19);
		textFieldWidth.setColumns(10);
		panelDimensionFrame.add(textFieldWidth);
		
		lblHigh = new JLabel("Alto:");
		lblHigh.setBounds(217, 7, 40, 15);
		panelDimensionFrame.add(lblHigh);
		
		textFieldHeight = new JTextField("");
		textFieldHeight.setBounds(259, 5, 135, 19);
		textFieldHeight.setColumns(10);
		panelDimensionFrame.add(textFieldHeight);
	}

	private void titleDimensionFrames() 
	{
		inicializedTitleFrame();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		lblFrames = new JLabel("Dimensión de los fotograma:");
		lblFrames.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelTitleFrame.add(lblFrames);
	}

	private void numberFrames() {
		inicializedNumFrames();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		lblNewLabel = new JLabel("Cantidad de fotogramas:");
		lblNewLabel.setBounds(5, 6, 177, 15);
		panelNumFrames.add(lblNewLabel);
		
		textFieldNumFrames = new JTextField("");
		textFieldNumFrames.setBounds(187, 5, 212, 18);
		textFieldNumFrames.setPreferredSize(new Dimension(4, 18));
		textFieldNumFrames.setColumns(10);
		panelNumFrames.add(textFieldNumFrames);
	}

	private void inicializedDimensionFrame() {
		panelDimensionFrame = new JPanel();
		panelDimensionFrame.setLayout(null);
		panelFrames.add(panelDimensionFrame);
	}

	private void inicializedTitleFrame() 
	{
		panelTitleFrame = new JPanel();
		panelTitleFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelFrames.add(panelTitleFrame);
	}

	private void inicializedNumFrames() {
		panelNumFrames = new JPanel();
		panelNumFrames.setLayout(null);
		panelFrames.add(panelNumFrames);
	}

	private void inicializedPanelFrames() {
		panelFrames = new JPanel();
		panelFrames.setBounds(5, 125, 421, 107);
		panelFrames.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Fotogramas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panelFrames.setLayout(new GridLayout(0, 1, 0, 0));
		panelFrames.setVisible(false);
		propertiesPanel.add(panelFrames);
	}

	private void propertyName() 
	{
		initializedPanelName();
		// REFACTORIZAR LOS COMPONENTES LUEGO DE TERMINAR LA VENTANA DE NUEVO ACTOR
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(5, 18, 60, 19);
		panelName.add(lblName);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblError.setBounds(70, 0, 346, 15);
		panelName.add(lblError);
		
		textFieldName = new JTextField("");
		textFieldName.addKeyListener(new ActorNameAdapterListener(textFieldName, okButton, model,lblError));
		textFieldName.setBounds(70, 18, 346, 19);
		textFieldName.setColumns(10);
		panelName.add(textFieldName);
	}

	private void buttons() 
	{
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		{
			
			okButton.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) 
				{
					if(enableNewActor) 
					{
						okButton.setEnabled(true);
					}
				}
			});
			
			okButton.addActionListener(new BtnAddActorActionListener(treeScenes, canvas, textFieldName, textFieldImagen, textFieldNumFrames, textFieldWidth, textFieldHeight, this));
			okButton.setEnabled(false);
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
		propertiesPanel.setBorder(new TitledBorder(null, "Propiedades", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		propertiesPanel.setLayout(null);
		globalPanel.add(propertiesPanel);
	}

	private void initializedPanelImage() {
		panelImage = new JPanel();
		panelImage.setBounds(5, 60, 428, 59);
		propertiesPanel.add(panelImage);
	}

	private void initializedPanelName() {
		panelName = new JPanel();
		panelName.setBounds(5, 17, 428, 43);
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
		JLabel lblTitle = new JLabel("Complete las siguientes propiedades:");
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 12));
		headerPanel.add(lblTitle);
	}

	private void initializedDialog(MainWindowModel model, JTree treeScenes, Canvas canvas) 
	{
		this.model = model;
		this.treeScenes=treeScenes;
		this.canvas = canvas;
		setTitle("Nuevo Actor");
		setBounds(100, 100, 450, 400);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		globalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout(new BorderLayout(0, 0));
	}
}
