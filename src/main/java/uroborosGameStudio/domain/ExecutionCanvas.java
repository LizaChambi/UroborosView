package uroborosGameStudio.domain;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class ExecutionCanvas extends Canvas {
	
	public ExecutionCanvas() {
//		setBackground(Color.black);
	}
	
	public void paint(Graphics boll) {
		boll.setColor(Color.black);
		boll.fillOval(125, 125, 54, 54);
		boll.drawString("Compartiendo la visual", 45, 45);
		
	}
	
	public void update(Graphics boll) {
		paint(boll);
	}

}
