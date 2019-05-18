package uroborosGameStudio.ui.componentListeners;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.ui.components.ActorsPanel;

public class MouseDragActorHandlers  extends MouseAdapter 
{
	private Point offset;
    private ActorsPanel actorsPanel;
    private ActorWrapper actor;
    private JTextField posXField;
    private JTextField posYField;

    public MouseDragActorHandlers(ActorsPanel actorsPanel, ActorWrapper actor, JTextField posXField, JTextField posYField) 
    {
		this.actorsPanel = actorsPanel;
		this.actor = actor;
		this.posXField = posXField;
		this.posYField = posYField;
	}

	@Override
    public void mousePressed(MouseEvent e) 
    {
        JLabel label = (JLabel) e.getComponent();
        actorsPanel.moveToFront(label);
        offset = e.getPoint();
        
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        int x = e.getPoint().x - offset.x;
        int y = e.getPoint().y - offset.y;
        Component component = e.getComponent();
        Point location = component.getLocation();
        location.x += x;
        location.y += y;
        component.setLocation(location);
        
        actor.setPosition(location.x, location.y);
        posXField.setText(String.valueOf(actor.getX()));
        posYField.setText(String.valueOf(actor.getY()));
        posXField.updateUI();
        posYField.updateUI();
    }
}
