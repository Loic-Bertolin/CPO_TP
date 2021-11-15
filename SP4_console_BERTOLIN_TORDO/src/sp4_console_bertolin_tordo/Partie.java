/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_bertolin_tordo;

/**
 *
 * @author loicb
 */
import java.util.Random;
public class Partie {
    Joueur[] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille grilleJeu;
    
    public Partie(Joueur unJoueur , Joueur autreJoueur){
        Random couleur = new Random ();
        int alea = couleur.nextInt(1);
        if (alea==0){
            //Jaune commence
            
        }
        else{
            //Rouge commence
        }
        // joue a tour de role
        //regarder si un gagnant + annonce gagnant
    }
    public void inisialiserPartie(){
        Grille uneGrille;
        for (int j=0;j<21;j++){
            Jeton unJeton=new Jeton ("Jaune");
        }
        for (int r=0;r<21;r++){
            Jeton unJeton=new Jeton ("Rouge");
        }
    }
    public void débuterPartie(){
        
    }
    public void attribuerCouleursAuxJoueurs(Joueur unJoueur , Joueur autreJoueur){
        Random couleur = new Random ();
        int alea = couleur.nextInt(1);
        if (alea==0){
            unJoueur.affecterCouleur("Jaune");
            autreJoueur.affecterCouleur("Rouge"); 
        }
        else{
            unJoueur.affecterCouleur("Rouge");
            autreJoueur.affecterCouleur("Jaune");
        }
    }
}
