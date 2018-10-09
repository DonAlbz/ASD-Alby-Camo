
package asd;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cella extends JPanel{
    
    private boolean colorata;
    private Color bckColore;
        
    public Cella() 
    {
        setOpaque( true );
        bckColore = getBackground();
            
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1) );
    }
        
    public void switchColore() {
        setBackground(colorata ? bckColore : Color.GREEN);
        colorata = !colorata;
    }
        
        
}
