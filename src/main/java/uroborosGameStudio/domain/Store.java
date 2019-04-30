package uroborosGameStudio.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Proyect 
{
	// private File file;
	
	public Proyect() // "datos.obj"
	{
		//this.file = new File(name); 
	}
	
	public void escritura(GameData game) 
	{
		File file = new File("datos.obj");
		try 
		{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(game);
			oos.close();
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lectura()
	{
		ObjectInputStream ois = null;
		File file = new File("datos.obj");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ois= new ObjectInputStream(fis);
			GameData game = (GameData) ois.readObject();
			System.out.println("Nombre de juego: " + game.getName() );
			System.out.println("Escenas: " + game.getScenes());
		
			List<SceneData> scenes = game.getScenes();
		
			for (int i=0; i<scenes.size();i++)
			{
				System.out.println("Nombre de Escena " + i+1 + ": " + scenes.get(i).getName() );
				System.out.println("Actores de Escena " + i+1 + ": " + scenes.get(i).getActors());
				System.out.println("** FIN DE ESCENA **");
			}
			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
