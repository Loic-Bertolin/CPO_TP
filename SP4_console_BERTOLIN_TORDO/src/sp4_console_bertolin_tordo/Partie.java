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
import java.util.Scanner;

public final class Partie {

    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu;

    public Partie(Joueur joueur1, Joueur joueur2) {
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        attribuerCouleursAuxJoueurs();

        Random couleur = new Random();
        int alea = couleur.nextInt(1);
        if (alea == 0) {
            joueurCourant = ListeJoueurs[0];
            System.out.println(ListeJoueurs[0].Nom + "commence");
        } else {
            joueurCourant = ListeJoueurs[1];
            System.out.println(ListeJoueurs[1].Nom + "commence");
        }
    }

    public void inisialiserPartie() {
        grilleJeu = new Grille(); // créé et afficher grille
        grilleJeu.afficherGrilleSurConsole();
        for (int i = 0; i < 21; i++) { //donner les jetons aux joueurs
            Jeton unJeton = new Jeton("Jaune");
            ListeJoueurs[0].ListeJetons[i] = unJeton;
            Jeton unJeton2 = new Jeton("Rouge");
            ListeJoueurs[1].ListeJetons[i] = unJeton2;
        }
        for (int i = 0; i < 5; i++) {
            Random position = new Random();
            int lig = position.nextInt(5);
            int col = position.nextInt(6);
            grilleJeu.placerTrouNoir(lig, col);
        }
    }

    public void débuterPartie() {
        inisialiserPartie();
        do {
            if (ListeJoueurs[0] == joueurCourant) {
                joueurCourant = ListeJoueurs[1];
            } else {
                joueurCourant = ListeJoueurs[0];
            }
            System.out.println("Tour suivant :" + joueurCourant.Nom);
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("1) Pose un jeton");
            System.out.println("2) Désintégrer un jeton");
            System.out.println("3) Récupérer un jeton");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            do {
                System.out.println("Erreur, il faut une des 3 actions");
                action = sc.nextInt();
            } while (action >= 1 && action <= 3);
            for (int i = 0; i < 42; i++) {
                switch (action) {
                    case 1:
                        System.out.println("Quelle colonne jouer ? ");
                        int col = sc.nextInt();
                        do {
                            System.out.println("Erreur, il faut une des 7 colonnes");
                            col = sc.nextInt();
                        } while (col >= 1 && col <= 7);
                        joueurCourant.nombreJetonRestants--;
                        Jeton j = joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants];
                        grilleJeu.ajouterJetonDansColonne(j, col + 1);
                        joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants] = null;

                    case 2:
                        System.out.println("Quelle colonne jouer ? ");
                        int col2 = sc.nextInt();
                        System.out.println("Quelle ligne jouer ? ");
                        int lig2 = sc.nextInt();
                        grilleJeu.supprimerJeton(lig2, col2);
                        grilleJeu.tasserGrille(col2);

                    case 3:
                        System.out.println("Quelle colonne jouer ? ");
                        int col3 = sc.nextInt();
                        System.out.println("Quelle ligne jouer ? ");
                        int lig3 = sc.nextInt();
                        joueurCourant.ajouterJeton(grilleJeu.recupererJeton(lig3,col3));
                        grilleJeu.supprimerJeton(lig3, col3);
                        grilleJeu.tasserGrille(col3);
                }
            }
        } while ((grilleJeu.etreGagnantePourJoueur(joueurCourant) == true) || (grilleJeu.etreRemplie() == true));
        System.out.println(joueurCourant.Nom + " a gagné, le jeu est terminé.");
    }

    public void attribuerCouleursAuxJoueurs() {
        Random couleur = new Random();
        int alea = couleur.nextInt(1);
        if (alea == 0) {
            ListeJoueurs[0].affecterCouleur("Jaune");
            System.out.println(ListeJoueurs[0].Nom + "est Jaune");
            ListeJoueurs[1].affecterCouleur("Rouge");
            System.out.println(ListeJoueurs[1].Nom + "est Rouge");
        } else {
            ListeJoueurs[0].affecterCouleur("Rouge");
            System.out.println(ListeJoueurs[0].Nom + "est Rouge");
            ListeJoueurs[1].affecterCouleur("Jaune");
            System.out.println(ListeJoueurs[1].Nom + "est Jaune");
        }
    }
}

//attention couleur jeton sur console = null !=rouge
//grille etre gagnant


//inisialiser partie

        //trou noir
        // integrateur
        //recup jeton

//Main

        //On crée deux joueurs
        //On crée une partie incluant ces deux joueurs en paramètre
        //On initialise la partie
        //On la lance
