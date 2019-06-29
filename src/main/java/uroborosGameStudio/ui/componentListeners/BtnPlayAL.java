package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.team.uroboros.uroboros.engine.Game;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class BtnPlayAL implements ActionListener 
{
	private Canvas canvas;
	private MainWindowModel model;
	private JButton btnStop;
	private JButton btnPlay;
	
	public BtnPlayAL(Canvas canvas, MainWindowModel model, JButton btnStop, JButton btnPlay) 
	{
		this.canvas = canvas;
		this.model = model;
		this.btnStop = btnStop;
		this.btnPlay = btnPlay;
	}

	public void actionPerformed(ActionEvent e) 
	{
		Thread t = new Thread() 
		{	
			@Override
			public void run() 
			{
				model.evalBehaviorsAndCollisions();
				model.playAudio();
				Game.start(canvas);
			}
		};
		t.start();
		this.btnPlay.setEnabled(false);
		this.btnStop.setEnabled(true);
	}
}
