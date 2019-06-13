package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import uroborosGameStudio.domain.GameObject;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnOpenAudioActionListener implements ActionListener
{
	private JTextField pathAudioField;
	private JPanel panel;
	private MainWindowModel model;
	
	public BtnOpenAudioActionListener(JTextField textFieldPathAudio, JPanel principalPanel, MainWindowModel model) 
	{
		this.model = model;
		this.pathAudioField = textFieldPathAudio;
		this.panel = principalPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JFileChooser jFile = new JFileChooser();
		jFile.setAcceptAllFileFilterUsed(false);
		addExtensionFilters(jFile);
		jFile.showOpenDialog(panel);
		setTextPath(jFile);
	}
	
	private void setTextPath(JFileChooser jFile) 
	{
		File archivo = jFile.getSelectedFile();
		if (archivo != null)
		{
			this.pathAudioField.setText(archivo.getAbsolutePath());
			
			// DESCOMENTAR CUANDO ESTE ARREGLADO EL PATH EN U-ENGINE
			//this.model.getItemSelected().setPathAudio(archivo.getAbsolutePath());
			this.model.getItemSelected().setPathAudio(archivo.getName());
		}
	}

	private void addExtensionFilters(JFileChooser jFile) 
	{
		FileFilter filterWAV = new FileNameExtensionFilter("WAV (.WAV)", "WAV");
		jFile.addChoosableFileFilter(filterWAV);
	}

}
