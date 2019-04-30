package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import uroborosGameStudio.domain.BodyPath;
import uroborosGameStudio.domain.SceneWrapper;
import uroborosGameStudio.domain.UGSProject;
import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnSaveProyect implements ActionListener {

	private MainWindowModel model;

	public BtnSaveProyect(MainWindowModel modelObject) {
		this.model = modelObject;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.save();
		extracted1();
	}

	/**
	 * Buscar un nombre adecuado para los 2 extracted
	 */
	private void extracted1() {
		List<BodyPath> paths = model.getProject().getPathsScenes();
		for (BodyPath bodyPath : paths) {
			extracted(bodyPath.getPaths());
		}
	}

	private void extracted(List<String> paths) {
		for (String archivo : paths) {
			try {
				escritura(archivo, model.getProject());
				lectura(archivo);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void escritura(String archivo, Object obj) throws IOException {
		FileOutputStream file = new FileOutputStream(
				model.getProject().getPath() + System.getProperty("file.separator") + archivo);
		ObjectOutputStream output = new ObjectOutputStream(file);
		output.writeObject(obj);
		output.flush();
		output.close();
	}

	public void lectura(String archivo) throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(
				model.getProject().getPath() + System.getProperty("file.separator") + archivo);
		ObjectInputStream input = new ObjectInputStream(file);
		UGSProject game = (UGSProject) input.readObject();

		System.out.println("Nombre de juego: " + game.getGameTitle());
		System.out.println("Escenas: " + game.getScenes());

		List<SceneWrapper> scenes = game.getScenes();

		for (int i = 0; i < scenes.size(); i++) {
			System.out.println("Nombre de Escena " + i + ": " + scenes.get(i).getName());
			System.out.println("Actores de Escena " + i + ": " + scenes.get(i).getActors().size());
			System.out.println(game.getPath());
			System.out.println("** FIN DE ESCENA **");
		}
		input.close();
	}

}
