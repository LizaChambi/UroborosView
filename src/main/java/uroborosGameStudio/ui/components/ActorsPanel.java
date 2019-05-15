package uroborosGameStudio.ui.components;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import uroborosGameStudio.ui.componentListeners.MouseDragActorHandlers;

public class ActorsPanel extends JLayeredPane  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer x;
	private Integer y;
	private File[] images;
    
	public ActorsPanel() 
    {
		this.x = 0;
        this.y = 0;
    	// Carga una lista de imágenes con la extención específica en una determinada carpeta.
        
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

        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
}
