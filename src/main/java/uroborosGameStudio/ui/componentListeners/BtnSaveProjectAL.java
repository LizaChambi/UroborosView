package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import uroborosGameStudio.domain.UGSProject;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnSaveProjectAL implements ActionListener {

	private MainWindowModel model;

	public BtnSaveProjectAL(MainWindowModel modelObject) {
		this.model = modelObject;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.save();
		try {
			// Lectura de los archivos guardados
			lectura();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	// Método de lectura para comprobar los archivos guardados:
	public void lectura() throws IOException, ClassNotFoundException 
	{
		FileInputStream file = new FileInputStream(
				model.getProject().getPathRoot() + System.getProperty("file.separator") + model.getGameTitle() + ".ugs");
		ObjectInputStream input = new ObjectInputStream(file);
		UGSProject game = (UGSProject) input.readObject();
		input.close();
		
//		System.out.println("Nombre de juego: " + game.getName());
//		System.out.println("Escenas: " + game.getScenes());
//
//		List<SceneWrapper> scenes = game.getScenes();
//
//		for (int i = 0; i < scenes.size(); i++) {
//			System.out.println("Nombre de Escena " + i + ": " + scenes.get(i).getName());
//			System.out.println("Actores de Escena " + i + ": " + scenes.get(i).getActors().size());
//			System.out.println(game.getPathRoot());
//			System.out.println("** FIN DE ESCENA **");
//		}
	}

}
