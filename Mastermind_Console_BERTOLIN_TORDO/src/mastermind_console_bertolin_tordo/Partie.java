/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pierre
 */
public class Partie {

    Grille grilleJeu = new Grille();
    Pioche pioche = new Pioche();
    HashMap sacDeTableaux;

    public Partie() {

    }

    public void initialiserPartie() {
        grilleJeu.viderGrille();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur :");
        Joueur joueur = new Joueur(sc.nextLine());

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

        sacDeTableaux = new HashMap();
        sacDeTableaux.put("Rouge", pioche.couleurRouge);
        sacDeTableaux.put("Jaune", pioche.couleurJaune);
        sacDeTableaux.put("Vert", pioche.couleurVert);
        sacDeTableaux.put("Bleu", pioche.couleurBleu);
        sacDeTableaux.put("Orange", pioche.couleurOrange);
        sacDeTableaux.put("Marron", pioche.couleurMarron);
        sacDeTableaux.put("Fushia", pioche.couleurFushia);
        sacDeTableaux.put("Noir", pioche.couleurNoir);

        String random1 = grilleJeu.couleur_aleatoire();
        Pion pion1 = new Pion(random1);
        pioche.ajouterPion_reponse(pion1);

        String random2 = grilleJeu.couleur_aleatoire();
        Pion pion2 = new Pion(random2);
        pioche.ajouterPion_reponse(pion2);

        String random3 = grilleJeu.couleur_aleatoire();
        Pion pion3 = new Pion(random3);
        pioche.ajouterPion_reponse(pion3);

        String random4 = grilleJeu.couleur_aleatoire();
        Pion pion4 = new Pion(random4);
        pioche.ajouterPion_reponse(pion4);
        System.out.println("Couleur générée pour la grille de réponse :");
        System.out.println(pioche.reponse.get(0).lireCouleur());
        System.out.println(pioche.reponse.get(1).lireCouleur());
        System.out.println(pioche.reponse.get(2).lireCouleur());
        System.out.println(pioche.reponse.get(3).lireCouleur());

    }

    public void debuterPartie() {
        initialiserPartie();
        int compteur_bonne_couleur = 0;
        int compteur_bien_place = 0;
        int remplissage = 0;
        int temp1 = 0;
        int temp2 = 0;
        int affichage = 0;
        int k = 0;

        //(grilleJeu.etreGagnantPourJoueur() == false) ||
        while (grilleJeu.etreRemplie() == false) {
            //while (grilleJeu.ligneRemplie() == true) {
            grilleJeu.afficherGrilleSurConsole();

            Scanner sc = new Scanner(System.in);
            System.out.println(" Posez vos jetons");
            System.out.println("1) Poser dans colonne 1");
            System.out.println("2) Poser dans colonne 2");
            System.out.println("3) Poser dans colonne 3");
            System.out.println("4) Poser dans colonne 4");
            int colonne = sc.nextInt() - 1;
            while (colonne < 1 && colonne > 4) {
                System.out.println("Erreur");
                colonne = sc.nextInt() - 1;
            }
            remplissage++;
            affichage++;
            System.out.println("Quelle couleur jouer parmis 'Rouge,Jaune,Vert,Bleu,Orange,Marron,Fushia,Noir' ? ");
            String couleur = sc.nextLine();

            while (!("Rouge".equals(couleur) || "Jaune".equals(couleur) || "Vert".equals(couleur) || "Bleu".equals(couleur) || "Orange".equals(couleur) || "Marron".equals(couleur) || "Fushia".equals(couleur) || "Noir".equals(couleur))) {
                //System.out.println("Quelle couleur jouer parmis 'Rouge,Jaune,Vert,Bleu,Orange,Marron,Fushia,Noir' ? ");
                couleur = sc.nextLine();
            }
            ArrayList<Pion> a = (ArrayList) sacDeTableaux.get(couleur);
            grilleJeu.ajouterPionDansLigne(a.get(0), colonne);

            if (pioche.reponse.get(colonne).lireCouleur() == a.get(0).lireCouleur()) {
                compteur_bien_place++;
                k++;
            }
            for (int i = 0; i < 4; i++) {
                if (pioche.reponse.get(i).lireCouleur() == a.get(0).lireCouleur()) {
                    compteur_bonne_couleur++;
                    break;
                }
            }

            if (affichage > 4) {
                System.out.println("TOUR PRÉCÉDENT");
                System.out.println("Nombre de couleur bien choisie : " + temp2);
                System.out.println("Nombre de pion bien placé : " + temp1 + "\n");
            }

            a.remove(0);
            if (compteur_bien_place == 4) {
                grilleJeu.afficherGrilleSurConsole();
                System.out.println("Vous avez gagné !");
                break;
            }

            if (remplissage == 4) {
                temp1 = compteur_bien_place;
                temp2 = compteur_bonne_couleur - k;
                System.out.println("TOUR ACTUEL");
                System.out.println("Nombre de couleur bien choisie : " + (compteur_bonne_couleur - k));
                System.out.println("Nombre de pion bien placé : " + compteur_bien_place + "\n");
                remplissage = 0;
                compteur_bien_place = 0;
                compteur_bonne_couleur = 0;
                k = 0;
            }
        }

    }
}


/*
FONCTIONNALITÉES NON TERMINÉE : 
on peut poser sur la colonne suivante alors que la ligne n'est pas pleine (ça s'entasse) --> vérifer avant que la ligne est remplie
 */
