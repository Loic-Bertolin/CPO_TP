/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_bertolin_tordo;

import java.util.Scanner;

/**
 *
 * @author loicb
 */

public class SP4_console_BERTOLIN_TORDO {

    /*SP4 console
     *Loïc Bertolin
     *Pierre Tordo
     *12/11/21
     */
    public static void main(String[] args) {
        /*System.out.println("Bienvenue au Puissance 4");
        Partie une_partie = new Partie();
        une_partie.débuterPartie();
        */
        
        Jeton j=new Jeton ("Rouge");
        System.out.println(j.lireCouleur());
        Cellule c=new Cellule();
        System.out.println(c.lireCouleurDuJeton());
        c.affecterJeton(j);
        System.out.println(c.lireCouleurDuJeton());
        Grille g=new Grille();
        g.afficherGrilleSurConsole();
        g.ajouterJetonDansColonne(j, 5);
        g.afficherGrilleSurConsole();
        g.ajouterJetonDansColonne(j, 5);
        g.afficherGrilleSurConsole();
        
        g.ajouterJetonDansColonne(j, 5);
        g.afficherGrilleSurConsole();        
        g.ajouterJetonDansColonne(j, 5);
        g.afficherGrilleSurConsole();

        
        
    }
    
}
