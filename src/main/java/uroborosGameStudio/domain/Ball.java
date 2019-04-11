package uroborosGameStudio.domain;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class Ball extends Canvas implements MouseListener, MouseMotionListener{
	
	private MainWindowModel model;
	
	public Ball() {
//		setBackground(Color.black);
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}

	public void paint(Graphics boll) {
		boll.setColor(Color.black);
		boll.fillOval(125, 125, 54, 54);
		boll.drawString("Compartiendo la visual", 45, 45);
		
		// CREAR ACA UNA LISTA DE ESCENAS CON ACTORES PARA USAR COMO BBDD AL CANVAS
		//List<Scene> escenas = new ArrayList<Scene>();
		// escenas.add(actor1);
		// escenas.add(actor2); 
		// ....
		
		/*
		for ( indiceDeEscena)
		{
			Escena esc = model.getSceneIn(indiceDeEscena)
			for (indiceDeActor)
			{
				Actor act = esc.getActorIn(indiceDeActor)
				boll.drawImage(act.getImage(), act.point.x, act.point.y, act.dimension.width, act.dimension.height, null);
				
			}
		}
		*/
		try {
			boll.drawImage(ImageIO.read(new File("images/Uroboros-Logo.png")), 200, 200, 50, 50, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void mouseDragged(MouseEvent e) {
		Graphics g = this.getGraphics(); 
		  
        g.setColor(Color.red); 
  
        // get X and y position 
        int x, y; 
        x = e.getX(); 
        y = e.getY(); 
  
        // draw a Oval at the point where mouse is moved 
        g.fillOval(x, y, 5, 5); 		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		Graphics g = this.getGraphics(); 
		  
        g.setColor(Color.red); 
  
        // get X and y position 
        int x, y; 
        x = e.getX(); 
        y = e.getY(); 
  
        // draw a Oval at the point  
        // where mouse is moved 
        g.fillOval(x, y, 5, 5); 		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
