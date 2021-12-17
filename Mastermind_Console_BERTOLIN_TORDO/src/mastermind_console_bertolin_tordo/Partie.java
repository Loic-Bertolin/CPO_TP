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

    public void initialiserPartie() {
        grilleJeu.viderGrille();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur :");
        Joueur joueur = new Joueur(sc.nextLine());
    }

    public void debuterPartie() {
        initialiserPartie();
        
        while ((grilleJeu.etreGagnantPourJoueur() == false) && (grilleJeu.etreRemplie() == false)) {
            grilleJeu.afficherGrilleSurConsole();
            System.out.println(" Posez vos 4 jetons");
            System.out.println("1) Poser dans colonne 1");
            System.out.println("2) Poser dans colonne 2");
            System.out.println("3) Poser dans colonne 3");
            System.out.println("4) Poser dans colonne 4");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            while (action < 1 && action > 4) {
                System.out.println("Erreur, il faut une des 4 actions");
                action = sc.nextInt();
            }
            switch (action) {
                case 1 -> {
                    boolean result;
                    System.out.println("Quelle colonne jouer ? ");
                    int col = sc.nextInt() - 1;
                    while (col < 0 || col > 4) {
                        System.out.println("Erreur, saisir une colonne");
                        col = sc.nextInt() - 1;
                    }
                    joueurCourant.nombreJetonRestants--;

                    int i = 0;
                    while (grilleJeu.CellulesJeu[i][col].jetonCourant != null) {
                        i++;
                        if (i == 5) {
                            break;
                        }
                    }
                    if (grilleJeu.CellulesJeu[i][col].presenceDesintegrateur() == true) {
                        grilleJeu.CellulesJeu[i][col].recupererDesintegrateur();
                        joueurCourant.nombreDesintegrateurs++;
                    }

                    result = grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants], col);
                    while (result == false) {
                        System.out.println("Colonne pleine, choisissez une autre colonne");
                        col = sc.nextInt() - 1;
                        result = grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants], col);
                    }

                    // regarder si on a un désintégrateur sur (i,col)
                    grilleJeu.afficherGrilleSurConsole();
                }

                case 2 -> {
                    // désintégrer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig2 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col2 = sc.nextInt() - 1;
                    while (grilleJeu.CellulesJeu[lig2][col2].lireCouleurDuJeton() == joueurCourant.Couleur) {
                        System.out.println("Le jeton est de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig2 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col2 = sc.nextInt() - 1;
                    }
                    grilleJeu.supprimerJeton(lig2, col2);
                    grilleJeu.tasserGrille(col2);
                    grilleJeu.afficherGrilleSurConsole();
                    joueurCourant.nombreDesintegrateurs--;
                    System.out.println("Nombre de désintégrateur : " + joueurCourant.nombreDesintegrateurs + "du " + joueurCourant);
                }

                case 3 -> {
                    // récupérer jeton
                    System.out.println("Quelle ligne jouer ? ");
                    int lig3 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col3 = sc.nextInt() - 1;
                    while (grilleJeu.CellulesJeu[lig3][col3].lireCouleurDuJeton() != joueurCourant.Couleur) {
                        System.out.println("Le jeton n'est pas de votre couleur ");
                        System.out.println("Quelle ligne jouer ? ");
                        lig3 = sc.nextInt() - 1;
                        System.out.println("Quelle colonne jouer ? ");
                        col3 = sc.nextInt() - 1;
                    }
                    //joueurCourant.ajouterJeton(grilleJeu.recupererJeton(lig3, col3));
                    grilleJeu.supprimerJeton(lig3, col3);
                    grilleJeu.tasserGrille(col3);
                    grilleJeu.afficherGrilleSurConsole();
                }
            }
            if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false) {
                if (ListeJoueurs[0] == joueurCourant) {
                    joueurCourant = ListeJoueurs[1];
                } else {
                    joueurCourant = ListeJoueurs[0];
                }

                System.out.println("Tour suivant :" + joueurCourant.Nom);
                System.out.println("Nombre de jeton de " + joueurCourant.Nom + " est : " + joueurCourant.nombreJetonRestants);
                System.out.println("Nombre de désintégrateur de " + joueurCourant.Nom + " est : " + joueurCourant.nombreDesintegrateurs);
            }

        }
        System.out.println(joueurCourant.Nom + " a gagné, le jeu est terminé.");
    }

}


