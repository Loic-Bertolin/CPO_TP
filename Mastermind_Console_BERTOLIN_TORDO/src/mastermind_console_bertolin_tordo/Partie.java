/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

import java.util.ArrayList;
import java.util.HashMap;
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
        // création du nombre de pion pour la pioche du joueur
        for (int i = 0; i < 48; i++) {
            Pion pion1 = new Pion("Rouge");
            pioche.ajouterPion(pion1);
            Pion pion2 = new Pion("Jaune");
            pioche.ajouterPion(pion2);
            Pion pion3 = new Pion("Vert");
            pioche.ajouterPion(pion3);
            Pion pion4 = new Pion("Bleu");
            pioche.ajouterPion(pion4);
            Pion pion5 = new Pion("Gris");
            pioche.ajouterPion(pion5);
            Pion pion6 = new Pion("Turquoise");
            pioche.ajouterPion(pion6);
            Pion pion7 = new Pion("Fushia");
            pioche.ajouterPion(pion7);
            Pion pion8 = new Pion("Noir");
            pioche.ajouterPion(pion8);

        }
        // Création d'un sac de tableau avec des mot clé faisant référence à l'ArrayList de pion correspondant
        sacDeTableaux = new HashMap();
        sacDeTableaux.put("Rouge", pioche.couleurRouge);
        sacDeTableaux.put("Jaune", pioche.couleurJaune);
        sacDeTableaux.put("Vert", pioche.couleurVert);
        sacDeTableaux.put("Bleu", pioche.couleurBleu);
        sacDeTableaux.put("Gris", pioche.couleurGris);
        sacDeTableaux.put("Turquoise", pioche.couleurTurquoise);
        sacDeTableaux.put("Fushia", pioche.couleurFushia);
        sacDeTableaux.put("Noir", pioche.couleurNoir);

        // On génère les 4 pions aléatoirement que l'on va devoir deviner
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
        int compteur_bonne_couleur = 0; // compteur qui va stocker les bonnes couleurs
        int compteur_bien_place = 0; // compteur qui va stocker les couleurs bien placées
        int remplissage = 0;// s'incrémente jusqu'à 4 (ligne pleine) pour après indique les score
        int temp1 = 0; // compteur qui va stocker le nb de couleurs bien placé du tour précédent pour le rappeler au joueur
        int temp2 = 0; // compteur qui va stocker le nb de couleurs bien choisie du tour précédent pour le rappeler au joueur
        int affichage = 0; //s'incrémente à chaque tour et permet d'afficher les pions bien placé lorsque l'on passe à la ligne suivante
        //int k = 0;
        int[] choix_joueur = new int[4];

        //(grilleJeu.etreGagnantPourJoueur() == false) ||
        while (grilleJeu.etreRemplie() == false) {
            //while (grilleJeu.ligneRemplie() == true) {
            grilleJeu.afficherGrilleSurConsole();

            Scanner sc = new Scanner(System.in);
            System.out.println(" Entrez votre combinaison de 4 chiffres");
            System.out.println("1 = Rouge, 2 = Jaune, 3 = Vert, 4 = Bleu, 5 = Gris, 6 = Turquoise, 7 = Rose, 8 = Noir ");
            /*System.out.println("2) Poser dans colonne 2");
            System.out.println("3) Poser dans colonne 3");
            System.out.println("4) Poser dans colonne 4");*/
            int colonne = sc.nextInt();
            while (colonne < 1000 || colonne > 9999 || grilleJeu.verifNb(colonne) == false) {
                System.out.println("Erreur, entrez une combinaison de 4 chiffres");
                colonne = sc.nextInt();
            }
            remplissage++; //incrémente le comtpeur à chaque fois que le joueur joue
            affichage++;

            choix_joueur[0] = colonne % 10;
            colonne = colonne / 10;
            int b = colonne % 10;
            choix_joueur[1] = b;
            colonne = colonne / 10;
            int c = colonne % 10;
            choix_joueur[2] = c;
            colonne = colonne / 10;
            int d = colonne % 10;
            choix_joueur[3] = d;

            System.out.println(choix_joueur[0]);
            System.out.println(choix_joueur[1]);
            System.out.println(choix_joueur[2]);
            System.out.println(choix_joueur[3]);
            
            
            
            System.out.println(grilleJeu.convertion(choix_joueur[0]));
            
            
            
            
            
            
            System.out.println("Quelle couleur jouer parmis 'Rouge,Jaune,Vert,Bleu,Gris,Turquoise,Fushia,Noir' ? ");
            String couleur = sc.nextLine();

            while (!("Rouge".equals(couleur) || "Jaune".equals(couleur) || "Vert".equals(couleur) || "Bleu".equals(couleur) || "Gris".equals(couleur) || "Turquoise".equals(couleur) || "Fushia".equals(couleur) || "Noir".equals(couleur))) {
                couleur = sc.nextLine();
            }

            ArrayList<Pion> a = (ArrayList) sacDeTableaux.get(couleur);
            grilleJeu.ajouterPionDansLigne(a.get(0), colonne);

            //compare si la couleur du pion placé a l'endroit choisi est indentique à celui sur la grille de réponse
            if (pioche.reponse.get(colonne).lireCouleur() == a.get(0).lireCouleur()) {
                compteur_bien_place++;
                //k++;
            }
            //compare si la couleur du pion placé est présente dans la grille de réponse
            for (int i = 0; i < 4; i++) {
                if (pioche.reponse.get(i).lireCouleur() == a.get(0).lireCouleur()) {
                    compteur_bonne_couleur++;
                    break;
                }
            }

            //System.out.println(grilleJeu.ligneRemplie());
            //Affiche les scores du tour précédent lorsque l'on passe à la ligne suivante, soit 4 coups après
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
                temp2 = compteur_bonne_couleur - compteur_bien_place;
                System.out.println("TOUR ACTUEL");
                System.out.println("Nombre de couleur bien choisie : " + (compteur_bonne_couleur - compteur_bien_place));
                System.out.println("Nombre de pion bien placé : " + compteur_bien_place + "\n");
                remplissage = 0;
                compteur_bien_place = 0;
                compteur_bonne_couleur = 0;
                //k = 0;
            }
        }
        System.out.println("Vous avez perdu ! Tout les coups ont été utilisés");

    }
}


/*
FONCTIONNALITÉES NON TERMINÉE : 
on peut poser sur la colonne suivante alors que la ligne n'est pas pleine (ça s'entasse) --> vérifer avant que la ligne est remplie
 */
