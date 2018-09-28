package asd;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Finestra {
	
	public static final int LARGHEZZA = 800;
	public static final int ALTEZZA = 500;
	
	public Finestra()
	{
		JFrame finestra = new JFrame("Window");
	    finestra.setBounds(0,0,LARGHEZZA,ALTEZZA);
	    finestra.setVisible(true);
	    finestra.addWindowListener(new WindowAdapter()
	    {
	    	// metodo necessario per chiudere il processo quando viene chiusa la finestra
	        public void windowClosing(WindowEvent e)
	        {
	          System.exit(0);
	        }
	      });
	}
        
	
}



 