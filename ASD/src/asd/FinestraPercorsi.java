package asd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinestraPercorsi extends JFrame {

    private enum ActionOnClick {
        COLORA,
        ORIGINE,
        DESTINAZIONE,
        GENERA;
    }

    private ActionOnClick azione = ActionOnClick.COLORA;
    private Clicker clicker;
    private ButtonClicker buttonClicker = new ButtonClicker();
    private Cella[][] celle;
    private boolean[] colora;
    
    private JPanel pannelloSinistra, pannelloDestra;
    private JPanel[] pannelli;
    private int[] coordinateOrigine = {0, 0};
    private int[] coordinateDestinazione = {0, 0};
    
    JLabel inserisci_righe = new JLabel("Inserisci il numero delle righe");
    JLabel inserisci_colonne = new JLabel("Inserisci il numero delle colonne");
    JLabel inserisci_percentuale = new JLabel("Inserisci la percentuale di ostacoli");
    JButton genera = new JButton("Genera");
    JButton origineButton = new JButton("Imposta Origine");
    JButton destinazioneButton = new JButton("Imposta Destinazione");
    JTextField righe = new JTextField("4", 7);
    JTextField colonne = new JTextField("5", 7);
    JTextField percentualeOstacoli = new JTextField("10", 7);
    JTextField origineField = new JTextField(coordinateOrigine[0] + ", " + coordinateOrigine[1], 7);
    JTextField destinazioneField = new JTextField(coordinateDestinazione[0] + ", " + coordinateDestinazione[1], 7);
    
    public FinestraPercorsi() {
        super(Parametri.TITOLO_FINESTRA);
        setSize(Parametri.LARGHEZZA_FINESTRA, Parametri.ALTEZZA_FINESTRA);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        // inizializzazione del layout della finestra
        pannelli = inizializzazioneLayout();
        pannelloSinistra = pannelli[0];
        pannelloDestra = pannelli[1];
        
        // inizializzazione dei componenti come bottoni e text field
        inizializzaComponenti(pannelloSinistra);
        // inizializzazione delle celle
        inizializzaCelle(pannelloDestra);
        
        
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


        

    

    private void coloraDecolora(Cella c) {
        if (c.getBackground() != Parametri.COLORE_DESTINAZIONE && c.getBackground() != Parametri.COLORE_ORIGINE) {
            c.switchColore(Parametri.COLORE_CLICK);
        }
    }

    public void inizializzaCelle(JPanel pannello) {
        setSize(pannello.getWidth(), pannello.getHeight());
        pannello.setLayout(new GridLayout(10, 10));

        //colora = new boolean[celle.length * celle[0].length];
        clicker = new Clicker();
        
         for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cella c = new Cella(i,j);
                c.addMouseListener(clicker);//Ad ogni cella viene associato un mouse listener per scatenare un evento ad ogni click
                pannello.add(c);
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
            origineField.setText(x1 + ", " + y1);
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
            destinazioneField.setText(x1 + ", " + y1);
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
                case GENERA:
                    inizializzaCelle(pannelloDestra);
                    break;
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
            if((JButton) me.getSource() == genera) {
                azione = ActionOnClick.GENERA;
            }
            if ((JButton) me.getSource() == origineButton) {
                azione = ActionOnClick.ORIGINE;
            } else if ((JButton) me.getSource() == destinazioneButton) {
                azione = ActionOnClick.DESTINAZIONE;
            }
        }
    }
    
    private JPanel[] inizializzazioneLayout(){
        setLayout(new GridBagLayout());
        
        JPanel pannelloSinistra = new JPanel();
        JPanel pannelloDestra = new JPanel();
        pannelloSinistra.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints vincoli = new GridBagConstraints();
        vincoli.fill = GridBagConstraints.BOTH;
        
        vincoli.weighty = 1;
        double percentualeSpazioSx = Parametri.LARGHEZZA_PANNELLO_SINISTRA/100;
        vincoli.weightx = percentualeSpazioSx;
        vincoli.gridx = 0;
        pannelloSinistra.setSize(Parametri.LARGHEZZA_PANNELLO_SINISTRA, Parametri.ALTEZZA_PANNELLO_SINISTRA);
        add(pannelloSinistra,vincoli);
        
        double percentualeSpazioDx = Parametri.LARGHEZZA_PANNELLO_DESTRA/100;
        vincoli.weightx = percentualeSpazioDx;
        vincoli.gridx = 1;
        pannelloDestra.setSize(Parametri.LARGHEZZA_PANNELLO_DESTRA, Parametri.ALTEZZA_PANNELLO_DESTRA);
        add(pannelloDestra,vincoli);
        
        return new JPanel[] {pannelloSinistra,pannelloDestra};
    }
    
    private void inizializzaComponenti(JPanel pannello){
        pannello.setLayout(new GridLayout(11,1,30,20));
        pannello.add(inserisci_righe);
        pannello.add(righe);
        pannello.add(inserisci_colonne);
        pannello.add(colonne);
        pannello.add(inserisci_percentuale);
        pannello.add(percentualeOstacoli);
        genera.addMouseListener(buttonClicker);
        pannello.add(genera);
        pannello.add(origineButton);
        pannello.add(origineField);
        pannello.add(destinazioneButton);
        pannello.add(destinazioneField);
        
    }
}
