package asd;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FinestraPercorsi extends JFrame {
    
    public static final String TITOLO_FINESTRA = "Cammini Aciclici";
    public static final int LARGHEZZA_FINESTRA = 1200;
    public static final int ALTEZZA_FINESTRA = 800;
    
    private Clicker clicker;
    private Cella[] celle;
    private boolean[] colora;
    
    /*JButton pulsante1 = new JButton("Genera");
    JPanel pannello = new JPanel();
    JLabel ipLabel = new JLabel("IP host",SwingConstants.LEFT);
    JLabel passwordLabel = new JLabel("Password", SwingConstants.LEFT);
    JLabel fileDaInviareLabel = new JLabel("File da inviare", SwingConstants.LEFT);
    JTextField ipText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JTextField fileDaInviareText = new JTextField();*/
    
    public FinestraPercorsi(int rows, int cols)
    {
        super(TITOLO_FINESTRA);
        inizializzaCelle(rows, cols);
        
        /*ipText.setEditable(true);
        fileDaInviareText.setEditable(true);
        passwordText.setEchoChar('*');
        
        GridBagLayout grigliaAvanzata = new GridBagLayout();
        GridBagConstraints limite = new GridBagConstraints();
        pannello.setLayout(grigliaAvanzata);
        
        impostaLimite(limite, 0, 0, 1, 1, 35, 0);
        limite.fill = GridBagConstraints.NONE;
        limite.anchor = GridBagConstraints.EAST;
        grigliaAvanzata.setConstraints(ipLabel, limite);
        pannello.add(ipLabel);
        
        impostaLimite(limite,1,0,1,1,65,100); //campo IP host
        limite.fill = GridBagConstraints.HORIZONTAL;
        grigliaAvanzata.setConstraints(ipText,limite);
        pannello.add(ipText);
        
        pulsante1.setSize(300,80);
        pannello.add(pulsante1);
        
        setContentPane(pannello);*/
        
        
        setVisible(true);
    }
    

    private class Clicker extends MouseAdapter {
        
        public void mouseClicked(MouseEvent me) {
            coloraDecolora((Cella) me.getSource());
        }
    }

    private void coloraDecolora(Cella c) {
        c.switchColore();
    }
    
    private void inizializzaCelle(int rows, int cols)
    {
        setSize(LARGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout( new GridLayout(rows, cols) );
        celle = new Cella[rows * cols];
        colora = new boolean[rows * cols];
        clicker = new Clicker();

        for(int i=0; i<rows*cols; i++) {
            Cella c = new Cella();
            c.addMouseListener( clicker );
            add( c );
        }
    }
       
}
