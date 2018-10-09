package asd;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cella extends JPanel {

    private boolean colorata;
    private Color bckColore;
    private boolean obstacle = false;
    private int x;
    private int y;

    /**
     * Definisce una cella di colore bianco e con bordi neri
     * @param _x
     * @param _y
     */
    public Cella(int _x, int _y) {
        x = _x;
        y = _y;
        
        setOpaque(true);
        bckColore = getBackground();
        setBackground(Parametri.COLORE_CELLA);

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    public void switchColore(Color colore) {
        setBackground(colorata ? Parametri.COLORE_CELLA : colore);
        colorata = !colorata;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean _obstacle) {
        this.obstacle = _obstacle;
        
        if (colorata=obstacle){
            setBackground(Parametri.COLORE_OSTACOLO);         
        }
        else{
            setBackground(Parametri.COLORE_CELLA);            
        }        
    }

    
    public int getX1() {
        return x;
    }

    
    public int getY1() {
        return y;
    }
    
    public void setColore(Color colore){
        setBackground(colore);
            colorata= (colore != Parametri.COLORE_CELLA);
    }
}
