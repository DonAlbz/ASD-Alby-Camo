/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author alber
 */
public class Controller {

    private Cella[][] celle;
    private Cella origine;
    private Cella destinazione;
    private final FinestraPercorsi finestraPercorsi;
    private final OnClickGenera clickGenera = new OnClickGenera();
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
            }
        }
        generaOstacoli(percentualeOstacoli);
    }

    private void generaOstacoli(double percentualeOstacoli) {
        int totaleOstacoli = (int) Math.floor( celle.length * celle[0].length*percentualeOstacoli/100);
        Random r = new Random();
        int rX;
        int rY;
        int ostacoliInseriti=0;
        while(ostacoliInseriti<totaleOstacoli){
            rX=r.nextInt(celle.length);
            rY=r.nextInt(celle[0].length);
            if(!celle[rX][rY].isObstacle()){
                celle[rX][rY].setObstacle(true);
                ostacoliInseriti++;
            }
        }
    }

    private class OnClickGenera extends MouseAdapter {

        public void mouseClicked(MouseEvent me) {
            getInfo((JButton) me.getSource());
            creaCelle(righe, colonne, percentualeOstacoli);
            getOrigine();
            getDestinazione();
            finestraPercorsi.inizializzaCelle(celle);

        }

        private void getInfo(JButton jButton) {
            righe = Integer.parseInt(finestraPercorsi.getRighe());
            colonne = Integer.parseInt(finestraPercorsi.getColonne());
            percentualeOstacoli = Double.parseDouble(finestraPercorsi.getPercentualeOstacoli());
        }

        private void getOrigine() {
            origine=celle[finestraPercorsi.getCoordinateOrigine()[0]][finestraPercorsi.getCoordinateOrigine()[1]];            
        }

        private void getDestinazione() {
            destinazione=celle[finestraPercorsi.getCoordinateDestinazione()[0]][finestraPercorsi.getCoordinateDestinazione()[1]];            
        }

    }

}
