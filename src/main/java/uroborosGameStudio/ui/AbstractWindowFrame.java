package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class AbstractWindowFrame implements Runnable, WindowListener, ComponentListener {

	private JFrame frame;
	private String title = "Uroboros Game Studio";
	private Integer width = 0;
	private Integer height = 0;
	private Dimension resolution = new Dimension(width, height);
	private boolean resizable = true;

	public static void main(String[] args) { new AbstractWindowFrame().run(); }

	public AbstractWindowFrame() {
		this.initializeFrame();
		this.frame.pack();
	}
	
	private void initializeFrame() {
		this.frame = new JFrame(this.title);
		this.frame.setLayout(new BorderLayout());
		this.frame.setPreferredSize(this.resolution);
		this.frame.setMinimumSize(this.resolution);
		this.frame.setVisible(false);
		this.frame.setResizable(this.resizable);
		this.frame.setLocationRelativeTo(null);
		this.frame.addWindowListener(this);
		this.frame.addComponentListener(this);
	}

	public void run() {	this.open(); }
	
	private void open() {
		if(!this.frame.isVisible()) {
			this.frame.setVisible(true);
		}
	}

	public void componentResized(ComponentEvent e) { }

	public void componentMoved(ComponentEvent e) { }

	public void componentShown(ComponentEvent e) { }

	public void componentHidden(ComponentEvent e) { }

	public void windowOpened(WindowEvent e) { }

	public void windowClosing(WindowEvent e) { System.exit(0); }

	public void windowClosed(WindowEvent e) { }

	public void windowIconified(WindowEvent e) { }

	public void windowDeiconified(WindowEvent e) { }

	public void windowActivated(WindowEvent e) { }

	public void windowDeactivated(WindowEvent e) { }

}
