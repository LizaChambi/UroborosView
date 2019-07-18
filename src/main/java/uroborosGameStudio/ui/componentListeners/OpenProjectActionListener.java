package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.EditorWindow;

public class OpenProjectActionListener implements ActionListener 
{
	private MainWindowModel model;
	private JFrame frame;
	private JPanel panel;

	public OpenProjectActionListener(MainWindowModel model, JFrame frame, JPanel centerPanel) 
	{
		this.model = model;
		this.frame = frame;
		this.panel = centerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String path = selectFile();
		if (! path.isEmpty())
		{
			this.model.loadProject(path);
			new EditorWindow().run();
			frame.dispose();
		}
	}

	private String selectFile() 
	{
		JFileChooser jFile = new JFileChooser();
		addExtensionFilters(jFile);
		jFile.showOpenDialog(this.panel);
		return textPath(jFile);
	}

	private String textPath(JFileChooser jFile) 
	{
		File archivo = jFile.getSelectedFile();
		if (archivo != null)
		{
			return archivo.getAbsolutePath();
		}
		return "";
	}

	private void addExtensionFilters(JFileChooser jFile) 
	{
		jFile.setAcceptAllFileFilterUsed(false);
		FileFilter filterUGS = new FileNameExtensionFilter("UGSProject (.UGS)", "ugs");
		jFile.addChoosableFileFilter(filterUGS);
	}

}
