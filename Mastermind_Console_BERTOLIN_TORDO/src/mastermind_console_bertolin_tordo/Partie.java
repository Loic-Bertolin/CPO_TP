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
    HashMap sacDeTableaux;

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
        Pioche pioche = new Pioche();

        while ((grilleJeu.etreGagnantPourJoueur() == false) && (grilleJeu.etreRemplie() == false)) {
            //while (grilleJeu.ligneRemplie() == true) {
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
                    int colonne = sc.nextInt() - 1;
                    while (colonne < 1 && colonne > 4) {
                        System.out.println("Erreur");
                        colonne = sc.nextInt() - 1;
                    }
                    System.out.println("Quelle couleur jouer parmis 'Rouge,Jaune,Vert,Bleu,Orange,Marron,Fushia,Noir' ? ");
                    String couleur = sc.nextLine();

                    while (!("Rouge".equals(couleur) || "Jaune".equals(couleur) || "Vert".equals(couleur) || "Bleu".equals(couleur) || "Orange".equals(couleur) || "Marron".equals(couleur) || "Fushia".equals(couleur) || "Noir".equals(couleur))) {
                        System.out.println("Erreur, choisir parmis 'Rouge,Jaune,Vert,Bleu,Orange,Marron,Fushia,Noir' ? ");
                        couleur = sc.nextLine();
                    }
                    ArrayList<Pion> a = (ArrayList) sacDeTableaux.get(couleur);
                    //System.out.println(a.get(0).lireCouleur());
                    grilleJeu.ajouterPionDansLigne(a.get(0), colonne);

                   
                    /*boolean temp;
                    temp = pioche1.reponse.contains(a.get(0));
                    if (temp == true) {
                        System.out.println("Nombre de couleur bien choisi : ");
                    } else {
                        System.out.println("Aucune couleur bien choisi : ");
                    }*/
                    /*String temp = a.get(0).lireCouleur();
                    System.out.println(temp);
                    
                    String temp1 = pioche.reponse.get(0).lireCouleur();
                    System.out.println(temp1);


                    for(int i = 0;i<4;i++){
                       if (1 == 1){
                           System.out.println("Une couleur bien choisie");
                       }
                       else{
                           System.out.println("Aucune couleur bien choisie");
                       }
                    }*/

                    a.remove(0);

                }

                case 2 -> {//Retirer pion
                    //chercher ligne
                    /*int derniereLigneRemplie = 0;
                        while (grilleJeu.PionJeu[derniereLigneRemplie][colonne] != null) {
                            derniereLigneRemplie++;
                        }*/
                }
            }

        }

    }
    // }

}


/*
on peut poser sur la colonne suivante alors que la ligne n'est pas pleine (ça s'entasse) --> vérifer avant que la ligne est remplie
Le message d'erreur s'affiche dès la première fois (on rentre direct dans le while alors que pas besoin)
faire case 2
vérifier que le joueur a gagné en comparant avec la grille de réponse --> + affciher les indices (point bien placé ou bonne couleur)

 */
