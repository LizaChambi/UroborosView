package uroborosGameStudio.domain;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class Ball extends Canvas implements MouseListener, MouseMotionListener{
	
	MainWindowModel comboBox;
	DummyActors bdActors;

	public Ball(MainWindowModel model) {
//		setBackground(Color.black);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public Ball(MainWindowModel comboBox, DummyActors bdActors) {
		this.comboBox = comboBox;
		this.bdActors = bdActors;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public MainWindowModel getComboBox() {
		return comboBox;
	}
	
	public void setComboBox(MainWindowModel comboBox) {
		this.comboBox = comboBox;
	}

	public void paint(Graphics boll) {
		boll.setColor(Color.black);
//		boll.fillOval(125, 125, 54, 54);
//		boll.drawString("Compartiendo la visual", 45, 45);
		
		if(comboBox.getItemSelectComboBox() != null) {
			boll.drawString(comboBox.getItemSelectComboBox(), 35, 30);
		}
		
		boll.drawImage(bdActors.getBall().getImage(), 150, 150, 50, 50, null);
		boll.drawImage(bdActors.getFlow().getImage(), 200, 200, 50, 50, null);
		boll.drawImage(bdActors.getKids().getImage(), 250, 250, 50, 50, null);
	}
	
	public void update(Graphics boll) {
		paint(boll);
	}

	public void mouseDragged(MouseEvent e) {
		Graphics g = this.getGraphics(); 
		  
        g.setColor(Color.red); 
  
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
		  
        g.setColor(Color.blue); 
  
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
