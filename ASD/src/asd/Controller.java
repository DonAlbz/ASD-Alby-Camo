/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author alber
 */
public class Controller {

    private Cella[][] celle;
    private FinestraPercorsi finestraPercorsi;
    private OnClickGenera clickGenera = new OnClickGenera();
    private int righe;
    private int colonne;
    private double percentualeOstacoli;

    Controller() {
        finestraPercorsi = new FinestraPercorsi();
        finestraPercorsi.getPulsanteGenera().addMouseListener(clickGenera);

    }

    private void creaCelle(int righe, int colonne, double percentualeOstacoli) {
        celle = new Cella[righe][colonne];
        //System.out.println(celle.length + "\t" + celle[0].length);
        for (int i = 0; i < celle.length; i++) {
            for (int j = 0; j < celle[0].length; j++) {
                celle[i][j] = new Cella(i, j);

                //TODO utilizzare percentuale ostacoli
            }
        }
    }

    private class OnClickGenera extends MouseAdapter {

        public void mouseClicked(MouseEvent me) {
            getInfo((JButton) me.getSource());
            creaCelle(righe, colonne, percentualeOstacoli); 
            finestraPercorsi.inizializzaCelle(celle);
            
        }

        private void getInfo(JButton jButton) {
            righe = Integer.parseInt(finestraPercorsi.getRighe());
            colonne=Integer.parseInt(finestraPercorsi.getColonne());
            percentualeOstacoli=Double.parseDouble(finestraPercorsi.getPercentualeOstacoli());
            //TODO acquisire gli altri parametri

            //creaCelle(2, 4, 10);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
