package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.componentListeners.BtnOpenImageActionListener;
import uroborosGameStudio.ui.componentListeners.CloseWindowDialogAL;
import uroborosGameStudio.ui.componentListeners.EditAnimationActionListener;
import uroborosGameStudio.ui.componentListeners.NumberWHAdapter;
import uroborosGameStudio.ui.components.ButtonUGS;

public class ConfigureAnimationDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel globalPanel = new JPanel();
	private MainWindowModel model;
	private Canvas canvas;
	private JTree treeScenes;
	private JPanel headerPanel;
	private JPanel propertiesPanel;
	private JPanel buttonPanel;
	private JPanel panelImage;
	private JLabel lblImage;
	private JTextField textFieldImagen;
	private JButton btnOpenImage;
	private JButton okButton = new JButton("Aceptar");
	private JPanel panelSpriteSheet = new JPanel();
	private JLabel lblAncho;
	private JTextField textFieldWidth;
	private JLabel lblHigh;
	private JTextField textFieldHeight;
	private JLabel lblNewLabel;
	private JLabel lblFrames;
	private JPanel panelNumFrames;
	private JTextField textFieldNumFrames;
	private JPanel panelTitleFrame;
	private JPanel panelDimensionFrame;
	private Boolean enableNewActor = false;
	private JLabel lblNumberError;
	private JPanel panelRatio;
	private JSpinner spinnerRatio;
	
	public ConfigureAnimationDialog(JTree treeScenes, Canvas canvas, MainWindowModel model) 
	{
		initializedDialog(treeScenes, canvas, model);
		initializedHeaderPanel();
		titleLabel();
		
		initializedPropertiesPanel();
		initializedButtonPanel();
		
		properties();
		buttons();
	}

	private void properties() 
	{
		propertyImage();
		propertyFrames();
	}

	private void propertyImage() 
	{
		initializedPanelImage();
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
	}

	private void propertyFrames() 
	{
		inicializedPanelFrames();
		numberFrames();
		titleDimensionFrames();
		dimensionFrames();
		ratioSpriteSheets();
	}

	private void ratioSpriteSheets() 
	{
		inicializeRatioPanel();
		panelRatio.setLayout(null);
		
		JLabel lblRatio = new JLabel("Ratio:");
		lblRatio.setBounds(5, 7, 42, 15);
		panelRatio.add(lblRatio);
		
		spinnerRatio = new JSpinner();
		spinnerRatio.setBounds(52, 5, 50, 20);
		spinnerRatio.setModel(new SpinnerListModel(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		panelRatio.add(spinnerRatio);
	}

	private void inicializeRatioPanel() {
		panelRatio = new JPanel();
		panelRatio.setBounds(5, 122, 411, 30);
		panelSpriteSheet.add(panelRatio);
	}

	private void dimensionFrames() 
	{
		inicializedDimensionFrame();
		lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(5, 21, 48, 15);
		panelDimensionFrame.add(lblAncho);
		
		lblNumberError = new JLabel("");
		lblNumberError.setForeground(Color.RED);
		lblNumberError.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNumberError.setBounds(63, 0, 336, 15);
		panelDimensionFrame.add(lblNumberError);

		textFieldWidth = new JTextField("");
		textFieldWidth.addKeyListener(new NumberWHAdapter(okButton, lblNumberError));
		textFieldWidth.setBounds(55, 19, 150, 19);
		textFieldWidth.setColumns(10);
		panelDimensionFrame.add(textFieldWidth);
		
		lblHigh = new JLabel("Alto:");
		lblHigh.setBounds(222, 21, 40, 15);
		panelDimensionFrame.add(lblHigh);
		
		textFieldHeight = new JTextField("");
		textFieldHeight.addKeyListener(new NumberWHAdapter(okButton, lblNumberError));
		textFieldHeight.setBounds(258, 19, 141, 19);
		textFieldHeight.setColumns(10);
		panelDimensionFrame.add(textFieldHeight);
	}

	private void titleDimensionFrames() 
	{
		inicializedTitleFrame();
		lblFrames = new JLabel("Dimensión de los sprites:");
		lblFrames.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelTitleFrame.add(lblFrames);
	}

	private void numberFrames() {
		inicializedNumFrames();
		lblNewLabel = new JLabel("Cantidad de sprites:");
		lblNewLabel.setBounds(5, 6, 150, 15);
		panelNumFrames.add(lblNewLabel);
		
		textFieldNumFrames = new JTextField("1");
		textFieldNumFrames.setBounds(157, 5, 242, 18);
		textFieldNumFrames.setPreferredSize(new Dimension(4, 18));
		textFieldNumFrames.setColumns(10);
		panelNumFrames.add(textFieldNumFrames);
	}

	private void inicializedDimensionFrame() {
		panelDimensionFrame = new JPanel();
		panelDimensionFrame.setBounds(5, 75, 411, 45);
		panelDimensionFrame.setLayout(null);
		panelSpriteSheet.add(panelDimensionFrame);
	}

	private void inicializedTitleFrame() 
	{
		panelTitleFrame = new JPanel();
		panelTitleFrame.setBounds(5, 53, 411, 19);
		panelTitleFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panelSpriteSheet.add(panelTitleFrame);
	}

	private void inicializedNumFrames() {
		panelSpriteSheet.setLayout(null);
		panelNumFrames = new JPanel();
		panelNumFrames.setBounds(5, 22, 411, 30);
		panelNumFrames.setLayout(null);
		panelSpriteSheet.add(panelNumFrames);
	}

	private void inicializedPanelFrames() {
		panelSpriteSheet.setBounds(8, 75, 421, 160);
		panelSpriteSheet.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sprite sheets", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		propertiesPanel.add(panelSpriteSheet);
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
			okButton.addActionListener(new EditAnimationActionListener(treeScenes, canvas, textFieldImagen, textFieldNumFrames, textFieldWidth, textFieldHeight, spinnerRatio, model, this));
			okButton.setEnabled(false);
			buttonPanel.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}

		new ButtonUGS("Cancel", new CloseWindowDialogAL(this), buttonPanel);
		
	}

	private void initializedButtonPanel() 
	{
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	
	private void initializedPropertiesPanel() 
	{
		propertiesPanel = new JPanel();
		propertiesPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Animaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		propertiesPanel.setLayout(null);
		globalPanel.add(propertiesPanel);
	}

	private void initializedPanelImage() {
		
		JPanel panelNote = new JPanel();
		FlowLayout fl_panelNote = (FlowLayout) panelNote.getLayout();
		fl_panelNote.setAlignment(FlowLayout.LEADING);
		panelNote.setBounds(8, 42, 421, 21);
		propertiesPanel.add(panelNote);
		
		JLabel lblNote = new JLabel("Nota: Asegúrese que la imagen elegida sea una hoja de sprites.");
		lblNote.setFont(new Font("Dialog", Font.PLAIN, 12));
		panelNote.add(lblNote);
		panelImage = new JPanel();
		panelImage.setBounds(8, 12, 421, 33);
		propertiesPanel.add(panelImage);
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

	private void initializedDialog(JTree treeScenes, Canvas canvas, MainWindowModel model2) 
	{
		this.treeScenes=treeScenes;
		this.canvas = canvas;
		this.model = model2;
		setTitle("Editar animación");
		setBounds(100, 100, 450, 380);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		globalPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(globalPanel, BorderLayout.CENTER);
		globalPanel.setLayout(new BorderLayout(0, 0));
	}
}
