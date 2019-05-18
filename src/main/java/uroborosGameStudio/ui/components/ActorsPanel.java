package uroborosGameStudio.ui.components;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.ActorWrapper;
import uroborosGameStudio.domain.Draggable;
import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.componentListeners.MouseDragActorHandlers;

public class ActorsPanel extends JLayeredPane  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private File[] images;
    private List<Draggable> textureLabels;
    private JTree treeScenes;
    private JTextField posXField;
    private JTextField posYField;
    private Canvas canvas;
	
	public ActorsPanel(Canvas canvas, MainWindowModel model, JTree treeScenes, JTextField posXTextField, JTextField posYTextField) 
    {
		this.canvas =canvas;
        this.textureLabels = new ArrayList<Draggable>();
        this.treeScenes = treeScenes;
        this.posXField = posXTextField;
        this.posYField = posYTextField;
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
	
	private void createLabelImage(ActorWrapper actor) 
	{
		// JLabel label = new JLabel(new ImageIcon(act.getImage()));
		JLabel label = new JLabel("");
		label.setBounds(0, 0, actor.getWidth(), actor.getHeight());
        //label.setSize(new Dimension(act.getWidth(), act.getHeight()));
		
		// LAS POSICIONES DEBEN ADAPTARSE A LAS DE U-ENGINE:
		// Falta método de transformar coordenadas en UEngine.

        label.setLocation(actor.getX().intValue(), actor.getX().intValue());
        
        MouseDragActorHandlers mh  = new MouseDragActorHandlers(this, actor, posXField, posYField);
        label.addMouseListener(mh);
        label.addMouseMotionListener(mh);
        
		ImageIcon ico = new ImageIcon(actor.getPathImage());
		ImageIcon ima = new ImageIcon(ico.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_SMOOTH));
		label.setLayout(null);
		label.setIcon(ima);
        this.textureLabels.add(new Draggable(actor.getName(),label));
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
