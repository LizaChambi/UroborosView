package uroborosGameStudio.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class AbstractWindowFrame implements Runnable, WindowListener, ComponentListener {

	protected JFrame frame;
	String title = "Uroboros Game Studio";
	Integer width = 0;
	Integer height = 0;
	Dimension resolution = new Dimension(width, height);
	private boolean resizable = true;
	static MainWindowModel model = new MainWindowModel();

	public void main(String[] args) { new AbstractWindowFrame().run(); }

	public AbstractWindowFrame() 
	{
		this.initializeFrame();
		this.frame.pack();
	}
	
	private void initializeFrame() {
		this.frame = new JFrame(this.title);
		this.frame.setLayout(new BorderLayout());
		this.frame.setVisible(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.addWindowListener(this);
		this.frame.addComponentListener(this);
	}

	public void run() {	this.open(); }
	
	protected void open() {
		if(!this.frame.isVisible()) {
			this.frame.setVisible(true);
		}
	}
	
	public MainWindowModel getModelObject()
	{
		return model;
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}

	public boolean isResizable() { return resizable; }

	public void setResizable(boolean resizable) { this.resizable = resizable; }

	public Integer getWidth() {	return width; }

	public void setWidth(Integer width) { this.width = width; }

	public Integer getHeight() { return height;	}

	public void setHeight(Integer height) { this.height = height; }

	public Dimension getResolution() { return resolution; }

	public void setResolution(Dimension resolution) { this.resolution = resolution; }

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
