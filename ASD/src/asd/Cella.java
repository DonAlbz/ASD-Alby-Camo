package asd;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Cella extends JPanel {

    private boolean colorata;
    private Color bckColore;
    private boolean isObstacle = false;
    private int x;
    private int y;

    public Cella(int _x, int _y) {
        x = _x;
        y = _y;
        setOpaque(true);
        bckColore = getBackground();
        setBackground(Color.WHITE);

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    public void switchColore(Color colore) {
        setBackground(colorata ? bckColore : colore);
        colorata = !colorata;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
