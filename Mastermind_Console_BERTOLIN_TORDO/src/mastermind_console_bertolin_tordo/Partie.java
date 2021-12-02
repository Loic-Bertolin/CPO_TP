/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

import java.util.Scanner;

/**
 *
 * @author pierre
 */
public class Partie {
    
    Grille grilleJeu = new Grille();
    
    public Partie() {
        
    }
    public void initialiserPartie(){
        grilleJeu.viderGrille();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur :");
        Joueur joueur = new Joueur(sc.nextLine());
    }
    public void debuterPartie(){
        initialiserPartie();
        while ((grilleJeu.etreGagnantPourJoueur() == false) && (grilleJeu.etreRemplie() == false)){
            grilleJeu.afficherGrilleSurConsole();
            System.out.println(" Posez vos 4 jetons");
            
        }
    }
}
