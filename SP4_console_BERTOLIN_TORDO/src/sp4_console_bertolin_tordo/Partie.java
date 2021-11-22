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
    Grille grilleJeu = new Grille();

    public Partie() {

    }

    public void inisialiserPartie() {
        grilleJeu.viderGrille(); // créé et afficher grille

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du premier joueur :");
        Joueur joueur1 = new Joueur(sc.nextLine());
        System.out.println("Entrer le nom du deuxiéme joueur :");
        Joueur joueur2 = new Joueur(sc.nextLine());
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;

        //grilleJeu.afficherGrilleSurConsole();
        attribuerCouleursAuxJoueurs();

        Random couleur = new Random();
        int alea = couleur.nextInt(2);
        if (alea == 1) {
            joueurCourant = ListeJoueurs[0];
            System.out.println(ListeJoueurs[0].Nom + " commence");
        } else {
            joueurCourant = ListeJoueurs[1];
            System.out.println(ListeJoueurs[1].Nom + " commence");
        }

        for (int i = 0; i < 21; i++) { //donner les jetons aux joueurs
            Jeton unJeton = new Jeton("Jaune");
            ListeJoueurs[0].ajouterJeton(unJeton);
            Jeton unJeton2 = new Jeton("Rouge");
            ListeJoueurs[1].ajouterJeton(unJeton2);
            
            
        }
        
        Random position = new Random();
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            int lig = position.nextInt(5);
            int col = position.nextInt(6);
            if (compteur < 2) {
                if (!grilleJeu.placerDesintegrateur(lig, col)) {
                    compteur--;
                }
                compteur++;
            }
            if (!grilleJeu.placerTrouNoir(lig, col)) {
                i--;
            }
        }
        for(int i=0;i<3;i++){
            int lig = position.nextInt(5);
            int col = position.nextInt(6);
            if (!grilleJeu.placerDesintegrateur(lig, col)){
                i--;
            }
    }
        //grilleJeu.afficherGrilleSurConsole();
    }

    public void débuterPartie() {
        inisialiserPartie();
        while ((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == false) && (grilleJeu.etreRemplie() == false) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == false)) {

            grilleJeu.afficherGrilleSurConsole();
            System.out.println("1) Pose un jeton");
            System.out.println("2) Désintégrer un jeton");
            System.out.println("3) Récupérer un jeton");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            while (action < 1 && action > 3) {
                System.out.println("Erreur, il faut une des 3 actions");
                action = sc.nextInt();
            }
            if (action == 2) {
                if (joueurCourant.nombreDesintegrateurs == 0) {
                    System.out.println("Action non valide, plus de désintégrateur");
                    while (action != 1 && action != 3) {
                        System.out.println("Erreur, il faut choisir entre 1 et 3");
                        action = sc.nextInt();
                    }
                }
            }
            switch (action) {
                case 1 -> {
                    boolean result;
                    System.out.println("Quelle colonne jouer ? ");
                    int col = sc.nextInt() - 1;
                    while (col < 0 || col > 6) {
                        System.out.println("Erreur, saisir une colonne");
                        col = sc.nextInt() - 1;
                    }
                    joueurCourant.nombreJetonRestants--;
                    result = grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants], col);
                    while (result == false) {
                        System.out.print("Colonne pleine, choisissez une autre colonne");
                        col = sc.nextInt() - 1;
                        result = grilleJeu.ajouterJetonDansColonne(joueurCourant.ListeJetons[joueurCourant.nombreJetonRestants], col);
                    }
                    grilleJeu.afficherGrilleSurConsole();
                }

                case 2 -> {
                    System.out.println("Quelle ligne jouer ? ");
                    int lig2 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col2 = sc.nextInt() - 1;
                    grilleJeu.supprimerJeton(lig2, col2);
                    grilleJeu.tasserGrille(col2);
                    grilleJeu.afficherGrilleSurConsole();
                    joueurCourant.nombreDesintegrateurs--;
                    System.out.println("Nombre de désintégrateur : " + joueurCourant.nombreDesintegrateurs + "du " + joueurCourant);
                }

                case 3 -> {
                    System.out.println("Quelle ligne jouer ? ");
                    int lig3 = sc.nextInt() - 1;
                    System.out.println("Quelle colonne jouer ? ");
                    int col3 = sc.nextInt() - 1;
                    joueurCourant.ajouterJeton(grilleJeu.recupererJeton(lig3, col3));
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

    public void attribuerCouleursAuxJoueurs() {
        Random couleur = new Random();
        int alea = couleur.nextInt(2);
        if (alea == 1) {
            ListeJoueurs[0].affecterCouleur("Jaune");
            System.out.println(ListeJoueurs[0].Nom + " est Jaune");
            ListeJoueurs[1].affecterCouleur("Rouge");
            System.out.println(ListeJoueurs[1].Nom + " est Rouge");
        } else {
            ListeJoueurs[0].affecterCouleur("Rouge");
            System.out.println(ListeJoueurs[0].Nom + " est Rouge");
            ListeJoueurs[1].affecterCouleur("Jaune");
            System.out.println(ListeJoueurs[1].Nom + " est Jaune");
        }
    }

}

//grille etre gagnant
//inisialiser partie
//trou noir
//integrateur
//recup jeton

