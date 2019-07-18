package uroborosGameStudio.ui.componentListeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class CboxEnableFrameListener implements ItemListener 
{
	JCheckBox cbxEnableFrames;
	JPanel panelFrames;
	
	public CboxEnableFrameListener(JCheckBox cbxEnableFrames, JPanel panelFrames) 
	{
		this.cbxEnableFrames = cbxEnableFrames;
		this.panelFrames = panelFrames;
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(cbxEnableFrames.isSelected())
		{
			panelFrames.setVisible(true);
		}
		else
		{
			panelFrames.setVisible(false);
		}
	}

}
