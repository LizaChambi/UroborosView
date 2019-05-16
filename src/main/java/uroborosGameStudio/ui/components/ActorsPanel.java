package uroborosGameStudio.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.Draggable;
import uroborosGameStudio.ui.componentListeners.MouseDragActorHandlers;

public class ActorsPanel extends JLayeredPane  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer x;
	private Integer y;
	//private File[] images;
    private List<Draggable> labels;
	
	public ActorsPanel() 
    {
		this.x = 0;
        this.y = 0;
        setBackground(Color.white);
    	// Carga una lista de imágenes con la extención específica en una determinada carpeta.
        /*
        this.images = new File("/home/chambi_liza/Documentos/Computer programming/TIP/resources").listFiles(new FileFilter() 
        {
            @Override
            public boolean accept(File pathname) 
            {
                String name = pathname.getName().toLowerCase();
                return name.endsWith(".png") || 
                                name.endsWith(".jpg") || 
                                name.endsWith(".bmp") ||
                                name.endsWith(".gif");
            }
        });
        */
        
        /*
        for (File imgFile : images) 
        {
            try {
                BufferedImage img = ImageIO.read(imgFile);
                JLabel label = new JLabel(new ImageIcon(img));
                label.setSize(label.getPreferredSize());
                label.setLocation(x, y);
                
                MouseDragActorHandlers mh  = new MouseDragActorHandlers(this);
                label.addMouseListener(mh);
                label.addMouseMotionListener(mh);
                add(label);
                
                x += 20;
                y += 20;
            } catch (IOException exp) {
                exp.printStackTrace();
            }

        }*/
    }
	
	private void createLabelImage(ActorWrapper act) 
	{
		// JLabel label = new JLabel(new ImageIcon(act.getImage()));
		JLabel label = new JLabel("");
		label.setBounds(0, 0, act.getWidth(), act.getHeight());
        //label.setSize(new Dimension(act.getWidth(), act.getHeight()));
        label.setLocation(x, y);
        
        MouseDragActorHandlers mh  = new MouseDragActorHandlers(this);
        label.addMouseListener(mh);
        label.addMouseMotionListener(mh);
        
		ImageIcon ico = new ImageIcon(act.getPath());
		ImageIcon ima = new ImageIcon(ico.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH));
		label.setLayout(null);
		label.setIcon(ima);
        labels.add(new Draggable(act.getName(),label));
        add(label);
	}
	
	public void addActor(ActorWrapper newActor)
	{
		createLabelImage(newActor);
	}

	public void setActors(List<ActorWrapper> actors)
	{
		removeAll();
		repaint();
		actors.forEach(act -> createLabelImage(act));
	}
	
/*
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
    */
}
