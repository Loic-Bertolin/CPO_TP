/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sp4_console_bertolin_tordo;

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
        /*Scanner sc = new Scanner ( System.in);
        System.out.println("Entrer le nom du premier joueur :");
        Joueur joueur1 = new Joueur(sc.nextLine());
        System.out.println("Entrer le nom du deuxiéme joueur :");
        Joueur joueur2 = new Joueur(sc.nextLine());
        //On crée deux joueurs
        //On crée une partie incluant ces deux joueurs en paramètre
        //On initialise la partie
        //On la lance
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
        
        
    }
    
}
