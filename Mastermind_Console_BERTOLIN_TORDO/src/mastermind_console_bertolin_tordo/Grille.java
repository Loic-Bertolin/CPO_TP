/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

/**
 *
 * @author pierre
 */
public class Grille {

    Pion[][] PionJeu = new Pion[12][4];
    Pion[][] PionReponse = new Pion[1][4];
    int derniereLigneRemplie = 0;

    public Grille() {
        for (int lignes = 0; lignes < 12; lignes++) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                PionJeu[lignes][colonnes] = null;
                if (lignes == 0) {
                    PionReponse[lignes][colonnes] = null;
                }
            }
        }
    }

    public boolean ajouterPionDansLigne(Pion unPion, int uneLigne) {

    }
    
    public boolean etreRemplie(){
       
    }
    
    public void viderGrille(){
        
    }
    public void afficherGrilleSurConsole(){
        
    }
    public Pion recupererPion(){
 
    }
    public String lireCouleurPion(int uneligne, int unecolonne){  
 
    }
    public boolean etreGagnantPourJoueur(){
   
    }
    public boolean ligneRemplie(){

    }
    public int[] verfierLigne(int uneligne, int unecolonne){

    }
   
}
