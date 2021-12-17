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
        Pioche pioche = new Pioche();
        for (int i = 0; i < 48; i++) {
            Pion pion1 = new Pion("Rouge");
            pioche.ajouterPion(pion1);
            Pion pion2 = new Pion("Jaune");
            pioche.ajouterPion(pion2);
            Pion pion3 = new Pion("Vert");
            pioche.ajouterPion(pion3);
            Pion pion4 = new Pion("Bleu");
            pioche.ajouterPion(pion4);
            Pion pion5 = new Pion("Orange");
            pioche.ajouterPion(pion5);
            Pion pion6 = new Pion("Marron");
            pioche.ajouterPion(pion6);
            Pion pion7 = new Pion("Fushia");
            pioche.ajouterPion(pion7);
            Pion pion8 = new Pion("Noir");
            pioche.ajouterPion(pion8);
        }
    }

    public void debuterPartie() {
        initialiserPartie();

        while ((grilleJeu.etreGagnantPourJoueur() == false) && (grilleJeu.etreRemplie() == false)) {
            grilleJeu.afficherGrilleSurConsole();
            System.out.println("1) Poser pion");
            System.out.println("2) Récupérer pion");
            Scanner sc = new Scanner(System.in);
            int action = sc.nextInt();
            while (action < 1 && action > 2) {
                System.out.println("Erreur, il faut une des 2 actions");
                action = sc.nextInt();
            }

            switch (action) {
                case 1 -> {//Poser pion
                    System.out.println(" Posez vos 4 jetons");
                    System.out.println("1) Poser dans colonne 1");
                    System.out.println("2) Poser dans colonne 2");
                    System.out.println("3) Poser dans colonne 3");
                    System.out.println("4) Poser dans colonne 4");
                    Scanner sc = new Scanner(System.in);
                    int colonne = sc.nextInt();
                    while (colonne < 1 && colonne > 4) {
                        System.out.println("Erreur, il faut une des 4 actions");
                        colonne = sc.nextInt();
                    }
                    System.out.println("Quelle couleur jouer parmis 'Rouge,Jaune,Vert,Bleu,Orange,Marron,Fushia,Noir' ? ");
                    String couleur = sc.nextLine();
                    while (!("Rouge".equals(couleur) || "Jaune".equals(couleur) || "Vert".equals(couleur) || "Bleu".equals(couleur) || "Orange".equals(couleur) || "Marron".equals(couleur) || "Fushia".equals(couleur) || "Noir".equals(couleur))) {
                        System.out.println("Erreur, choisir parmis 'Rouge,Jaune,Vert,Bleu,Orange,Marron,Fushia,Noir' ? ");
                        couleur = sc.nextLine();
                    }
                    //chercher ligne
                    
                    grilleJeu[derniereLigneRemplie][colonne].
                }

                case 2 -> {//Retirer pion
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
