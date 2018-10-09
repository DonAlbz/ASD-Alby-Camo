package asd;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FinestraPercorsi extends JFrame {
    
    public static final String TITOLO_FINESTRA = "Cammini Aciclici";
    public static final int LARGHEZZA_FINESTRA = 1200;
    public static final int ALTEZZA_FINESTRA = 800;
    private static final Color COLORE_CLICK=Color.YELLOW;
    private static final Color COLORE_ORIGINE=Color.GREEN;
    private static final Color COLORE_DESTINAZIONE=Color.RED;
    private static final Color COLORE_OSTACOLO=Color.DARK_GRAY;
    
      
    private Clicker clicker;
    private Cella[][] celle;
    private boolean[] colora;
    private int[] coordinateOrigine = new int[2];
    // la x dell'origine corrisponde a coordinateOrigine[0] 
    // la y dell'origine corrisponde a coordinateOrigine[1]
    
    JButton genera = new JButton("Genera");
    JPanel pannello = new JPanel();
    JTextField righe = new JTextField(10);
    JTextField colonne= new JTextField(10);;
    JTextField percentualeOstacoli= new JTextField(10);;
    /*
    JLabel ipLabel = new JLabel("IP host",SwingConstants.LEFT);
    JLabel passwordLabel = new JLabel("Password", SwingConstants.LEFT);
    JLabel fileDaInviareLabel = new JLabel("File da inviare", SwingConstants.LEFT);
    JTextField ipText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JTextField fileDaInviareText = new JTextField();*/
    
    public FinestraPercorsi()
    {
        super(TITOLO_FINESTRA);
        //@TODO inizializza Celle conterrà i valori acquisiti dai pulsati dell'interfaccia grafica
        //inizializzaCelle(20, 20, 10);
        setSize(LARGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
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
        
        pulsante1.setSize(300,80);*/
        setContentPane(pannello);
        
        pannello.add(righe);
        pannello.add(colonne);
        pannello.add(percentualeOstacoli);
        pannello.add(genera);
        
        setVisible(true);
        
    }

    

    private class Clicker extends MouseAdapter {
        
        public void mouseClicked(MouseEvent me) {
            coloraDecolora((Cella) me.getSource());
        }
    }

    private void coloraDecolora(Cella c) {
        c.switchColore(COLORE_CLICK);
    }
    
    public void inizializzaCelle(Cella[][] _celle){
        celle = _celle;      
        
        setLayout( new GridLayout(celle.length, celle[0].length) );
       // setLayout( new GridLayout() );
        /*
        Metodi utilizzati dai pulsanti:
        
        createObstacles(Double percentuale)
        
        impostaOrigine(int x, int y)
        
        impostaDestinazione(int x, int y)
        
        
        
       
        */
        
        
       
        colora = new boolean[celle.length * celle[0].length];
        clicker = new Clicker();

        for (int i = 0; i < celle.length; i++) {
            for (int j = 0; j < celle[0].length; j++) {
                Cella c = celle[i][j];
                System.out.println("i:" + i + "\t" + "j:" + j);
                System.out.println(Boolean.toString(c.isObstacle()));
                c.addMouseListener(clicker);
                add(c);
            }
        }


        
    }
    
    public JButton getPulsanteGenera(){
        return genera;
    }
    
    public String getRighe(){
        return righe.getText();
    }
    public String getColonne() {
        return colonne.getText();
    }
    
    public String getPercentualeOstacoli(){
        return percentualeOstacoli.getText();
    }
}
