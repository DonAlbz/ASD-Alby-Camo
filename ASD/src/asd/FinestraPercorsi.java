package asd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
    private static final Color COLORE_CLICK = Color.YELLOW;
    private static final Color COLORE_ORIGINE = Color.GREEN;
    private static final Color COLORE_DESTINAZIONE = Color.RED;
    private static final Color COLORE_OSTACOLO = Color.DARK_GRAY;

    private enum ActionOnClick {
        COLORA,
        ORIGINE,
        DESTINAZIONE;
    }

    private ActionOnClick azione = ActionOnClick.COLORA;
    private Clicker clicker;
    private ButtonClicker buttonClicker = new ButtonClicker();
    private Cella[][] celle;
    private boolean[] colora;

    
    
    JPanel nordPanel = new JPanel();
    JPanel centrePanel = new JPanel();
    JPanel southPanel = new JPanel();
    

  
    JLabel titolo = new JLabel("Prova del testo");
    JLabel inserisci_righe = new JLabel("Inserisci il numero delle righe");
    JLabel inserisci_colonne = new JLabel("Inserisci il numero delle colonne");
    JLabel inserisci_percentuale = new JLabel("Inserisci la percentuale di ostacoli");
    


    /**
     * la x dell'origine corrisponde a coordinateOrigine[0] la y dell'origine
     * corrisponde a coordinateOrigine[1]
     */
    private int[] coordinateOrigine = {0, 0};
    private int[] coordinateDestinazione = {0, 0};

    JButton genera = new JButton("Genera");
    JButton origineB = new JButton("Imposta Origine");
    JButton destinazioneB = new JButton("Imposta Destinazione");
    JPanel pannello = new JPanel();
    JTextField righe = new JTextField("4", 7);
    JTextField colonne = new JTextField("5", 7);
    JTextField percentualeOstacoli = new JTextField("10", 7);
    JTextField origineT = new JTextField(coordinateOrigine[0] + ", " + coordinateOrigine[1], 7);
    JTextField destinazioneT = new JTextField(coordinateDestinazione[0] + ", " + coordinateDestinazione[1], 7);

    ;

    /*
    JLabel ipLabel = new JLabel("IP host",SwingConstants.LEFT);
    JLabel passwordLabel = new JLabel("Password", SwingConstants.LEFT);
    JLabel fileDaInviareLabel = new JLabel("File da inviare", SwingConstants.LEFT);
    JTextField ipText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JTextField fileDaInviareText = new JTextField();*/
    
    public FinestraPercorsi() {
        super(TITOLO_FINESTRA);
        //@TODO inizializza Celle conterrà i valori acquisiti dai pulsati dell'interfaccia grafica
        //inizializzaCelle(20, 20, 10);
        setSize(LARGHEZZA_FINESTRA, ALTEZZA_FINESTRA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        Container container = this.getContentPane();
        int i=1;
        int j=4;
        container.setLayout(new GridLayout(i,j));
        JPanel[][] panelHolder = new JPanel[i][j];
        for(int m=0; m<i; m++)
        {
            for(int n=0; n<j; n++)
            {
                panelHolder[m][n] = new JPanel();
                container.add(panelHolder[m][n]);
            }
        }
        //JPanel pannelloInterazione = panelHolder[0][0];
        panelHolder[0][0].setLayout(new GridLayout(8,1));
        JPanel[][] componentHolder = new JPanel[8][1];
        for(int m=0; m<8; m++)
        {
            for(int n=0; n<1; n++)
            {
                componentHolder[m][n] = new JPanel();
                panelHolder[0][0].add(componentHolder[m][n]);
            }
        }
        componentHolder[0][0].add(titolo);
        componentHolder[1][0].add(inserisci_righe);
        componentHolder[2][0].add(righe);
        componentHolder[3][0].add(inserisci_colonne);
        componentHolder[4][0].add(colonne);
        componentHolder[5][0].add(inserisci_percentuale);
        componentHolder[6][0].add(percentualeOstacoli);
        componentHolder[7][0].add(genera);
        
        /*panelHolder[0][0].add(titolo);
        panelHolder[0][0].add(righe);
        panelHolder[0][0].add(colonne);
        panelHolder[0][0].add(percentualeOstacoli);
        panelHolder[0][0].add(genera);*/
        
        /*centrePanel.setLayout(new GridLayout(2,1));
        centrePanel.add(righe);
        centrePanel.add(colonne);
        centrePanel.add(percentualeOstacoli);
        nordPanel.add(prova);
        southPanel.add(genera);
        
        container.add(nordPanel,BorderLayout.EAST);
        container.add(centrePanel,BorderLayout.EAST);
        container.add(southPanel,BorderLayout.EAST);*/
        
        //getContentPane().add(nordPanel,BorderLayout.NORTH);
        //getContentPane().add(centrePanel,BorderLayout.CENTER);
        //getContentPane().add(southPanel,BorderLayout.SOUTH);
        //pack(); // setto la finestra alla minima dimensione necessaria
        
        



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

        
        
        
        /*setContentPane(pannello);
        
        pannello.add(righe);
        pannello.add(colonne);
        pannello.add(percentualeOstacoli);
        pannello.add(genera);*/
        
        setVisible(true);
        
    }

  /*
        setContentPane(pannello);

        pannello.add(righe);
        pannello.add(colonne);
        pannello.add(percentualeOstacoli);
        pannello.add(genera);
        pannello.add(origineT);
        origineB.addMouseListener(buttonClicker);
        pannello.add(origineB);
        pannello.add(destinazioneT);
        destinazioneB.addMouseListener(buttonClicker);
        pannello.add(destinazioneB);*/


        

    }

    private void coloraDecolora(Cella c) {
        if (c.getBackground() != Parametri.COLORE_DESTINAZIONE && c.getBackground() != Parametri.COLORE_ORIGINE) {
            c.switchColore(Parametri.COLORE_CLICK);
        }
    }

    public void inizializzaCelle(Cella[][] _celle) {
        celle = _celle;

        setLayout(new GridLayout(celle.length, celle[0].length));
        // setLayout( new GridLayout() );
        /*
        Metodi utilizzati dai pulsanti:
        
        createObstacles(Double percentuale)
        
        impostaOrigine(int x, int y)
        
        impostaDestinazione(int x, int y)
        
        
        FATTO
       
         */

        colora = new boolean[celle.length * celle[0].length];
        clicker = new Clicker();

        for (int i = 0; i < celle.length; i++) {
            for (int j = 0; j < celle[0].length; j++) {
                Cella c = celle[i][j];
                c.addMouseListener(clicker);//Ad ogni cella viene associato un mouse listener per scatenare un evento ad ogni click
                add(c); // la cella viene aggiunta alla griglia
            }
        }

    }

    public JButton getPulsanteGenera() {
        return genera;
    }

    public String getRighe() {
        return righe.getText();
    }

    public String getColonne() {
        return colonne.getText();
    }

    public String getPercentualeOstacoli() {
        return percentualeOstacoli.getText();
    }

    /**
     * Imposta una cella origine
     *
     * @param x1
     * @param y1
     */
    private void impostaOrigine(int x1, int y1) {
        if (celle[coordinateOrigine[0]][coordinateOrigine[1]].getBackground() == Parametri.COLORE_ORIGINE) {
            celle[coordinateOrigine[0]][coordinateOrigine[1]].setColore(Parametri.COLORE_CELLA);
        }
        if (celle[coordinateOrigine[0]][coordinateOrigine[1]].getBackground() != Parametri.COLORE_OSTACOLO) {
            coordinateOrigine[0] = x1;
            coordinateOrigine[1] = y1;
            origineT.setText(x1 + ", " + y1);
            celle[x1][y1].setColore(Parametri.COLORE_ORIGINE);
            azione = ActionOnClick.COLORA;
        }
    }

    /**
     * Imposta una cella destinazione
     *
     * @param x1
     * @param y1
     */
    private void impostaDestinazione(int x1, int y1) {
        if (celle[coordinateDestinazione[0]][coordinateDestinazione[1]].getBackground() == Parametri.COLORE_DESTINAZIONE) {
            celle[coordinateDestinazione[0]][coordinateDestinazione[1]].setColore(Parametri.COLORE_CELLA);
        }
        if (celle[coordinateDestinazione[0]][coordinateDestinazione[1]].getBackground() != Parametri.COLORE_OSTACOLO) {
            coordinateDestinazione[0] = x1;
            coordinateDestinazione[1] = y1;
            destinazioneT.setText(x1 + ", " + y1);
            celle[x1][y1].setColore(Parametri.COLORE_DESTINAZIONE);
            azione = ActionOnClick.COLORA;
        }
    }

    public int[] getCoordinateOrigine() {
        return coordinateOrigine;
    }

    public int[] getCoordinateDestinazione() {
        return coordinateDestinazione;
    }

    private class Clicker extends MouseAdapter {

        /**
         * Quando il mouse viene cliccato su una cella viene scatenato questo
         * evento. In funzione del valore della variabile "azione", viene
         * eseguita una delle seguenti azioni: colorazione della cella cliccata;
         * la cella cliccata diventa la cella origine; la cella cliccata diventa
         * la cella destinazione;
         *
         * @param me
         */
        public void mouseClicked(MouseEvent me) {
            switch (azione) {
                case COLORA:
                    coloraDecolora((Cella) me.getSource());
                    break;
                case ORIGINE:
                    impostaOrigine(((Cella) me.getSource()).getX1(), ((Cella) me.getSource()).getY1());
                    break;
                case DESTINAZIONE:
                    impostaDestinazione(((Cella) me.getSource()).getX1(), ((Cella) me.getSource()).getY1());
                    break;
            }
        }
    }

    private class ButtonClicker extends MouseAdapter {

        public void mouseClicked(MouseEvent me) {
            if ((JButton) me.getSource() == origineB) {
                azione = ActionOnClick.ORIGINE;
            } else if ((JButton) me.getSource() == destinazioneB) {
                azione = ActionOnClick.DESTINAZIONE;
            }
        }
    }
}
