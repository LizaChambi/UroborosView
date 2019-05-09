package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BtnOpenImageActionListener implements ActionListener 
{
	JTextField textFieldImagen;
	JPanel panelImage;
	
	public BtnOpenImageActionListener(JTextField textFieldImagen, JPanel panelImage) 
	{
		this.textFieldImagen = textFieldImagen;
		this.panelImage = panelImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JFileChooser jFile = new JFileChooser();
		jFile.setAcceptAllFileFilterUsed(false);
		addExtensionFilters(jFile);
		jFile.showOpenDialog(panelImage);
		setTextPath(jFile);
	}

	private void setTextPath(JFileChooser jFile) 
	{
		File archivo = jFile.getSelectedFile();
		if (archivo != null)
		{
			textFieldImagen.setText(archivo.getAbsolutePath());
		}
	}

	private void addExtensionFilters(JFileChooser jFile) 
	{
		FileFilter filterPNG = new FileNameExtensionFilter("PNG (.png)", "png");
		FileFilter filterJPEG = new FileNameExtensionFilter("JPEG (.jpeg/.jpg)", "jpeg", "jpg");
		jFile.addChoosableFileFilter(filterPNG);
		jFile.addChoosableFileFilter(filterJPEG);
	}

}
