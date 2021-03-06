/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author pierre
 */
public class Grille {

    Pion[][] PionJeu = new Pion[12][4];
    Pion[][] PionReponse = new Pion[1][4];
    int derniereLigneRemplie = 0;

    public Grille() {
        for (int lignes = 0; lignes < 12; lignes++) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                PionJeu[lignes][colonnes] = null;
                if (lignes == 0) {
                    PionReponse[lignes][colonnes] = null;
                }
            }
        }
    }

    public boolean ajouterPionDansLigne(Pion unPion, int uneColonne) {
        for (int i = 0; i < 12; i++) {
            if (PionJeu[i][uneColonne] == null) {
                PionJeu[i][uneColonne] = unPion;
                return true;
            }
        }
        return false;
    }

    public boolean etreRemplie() {
        for (int lignes = 0; lignes < 12; lignes++) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                if (PionJeu[lignes][colonnes] == null) {
                    return false;
                }
            }
        }
        return true;

    }

    public void viderGrille() {
        for (int lignes = 0; lignes < 12; lignes++) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                PionJeu[lignes][colonnes] = null;
            }
        }
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_ROSE = "\u001B[35m";
    public static final String ANSI_TURQUOISE = "\u001B[36m";

    public void afficherGrilleSurConsole() {
        System.out.print("\n" + "|");
        for (int lignes = 11; lignes >= 0; lignes--) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                if (PionJeu[lignes][colonnes] == null) {
                    System.out.print(" - |");
                } else if ("Rouge".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_RED + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else if ("Jaune".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_YELLOW + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else if ("Vert".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_GREEN + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else if ("Bleu".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_BLUE + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else if ("Gris".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_WHITE + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else if ("Turquoise".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_TURQUOISE + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else if ("Fushia".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print(ANSI_ROSE + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                } else { //if ("Noir".equals(PionJeu[lignes][colonnes].lireCouleur())) 
                    System.out.print(ANSI_BLACK + " ??? " + ANSI_RESET);
                    System.out.print("\033[0m|");
                }
            }
            if (lignes > 0) {
                System.out.print("\n|");
            } else {
                System.out.println("");
            }
        }
    }

    public Pion recupererPion(int unecolonne) {
        return PionJeu[derniereLigneRemplie][unecolonne];
    }

    public String couleur_aleatoire() {
        String[] tab_couleur = new String[8];

        tab_couleur[0] = "Rouge";
        tab_couleur[1] = "Jaune";
        tab_couleur[2] = "Vert";
        tab_couleur[3] = "Bleu";
        tab_couleur[4] = "Gris";
        tab_couleur[5] = "Turquoise";
        tab_couleur[6] = "Fushia";
        tab_couleur[7] = "Noir";
        Random pion = new Random();
        int alea = pion.nextInt(8);
        if (alea == 1) {
            return "Rouge";
        }
        if (alea == 2) {
            return "Jaune";
        }
        if (alea == 3) {
            return "Vert";
        }
        if (alea == 4) {
            return "Bleu";
        }
        if (alea == 5) {
            return "Gris";
        }
        if (alea == 6) {
            return "Turquoise";
        }
        if (alea == 7) {
            return "Fushia";
        } else {
            return "Noir";
        }
    }

    public String lireCouleurPion(int uneligne, int unecolonne) {
        return PionJeu[uneligne][unecolonne].lireCouleur();
    }

    public boolean etreGagnantPourJoueur() {
        return verifierLigne(derniereLigneRemplie)[0] == 4;
    }

    public boolean ligneRemplie() {
        int compteur;
        for (int lignes = 0; lignes < 12; lignes++) {
            compteur = 0;
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                if (PionJeu[lignes][colonnes] != null) {
                    compteur++;
                }
                if (compteur == 4) {
                    derniereLigneRemplie++;
                    compteur = 0;
                    return true;
                }
            }
        }
        return false;
    }

    public int[] verifierLigne(int uneligne) {
        ArrayList<Pion> verifJeu = new ArrayList<>();
        ArrayList<Pion> verifReponse = new ArrayList<>();
        int jetonBienPlace = 0;
        int jetonBonneCouleur = 0;
        int[] result = new int[2];
        result[0] = jetonBienPlace;
        result[1] = jetonBonneCouleur;
        for (int i = 0; i < 4; i++) {
            if (PionReponse[uneligne][i] == null) {
                return result;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (PionReponse[uneligne][i].lireCouleur() == PionJeu[uneligne][i].lireCouleur()) {
                jetonBienPlace++;
            } else {
                verifJeu.add(PionJeu[uneligne][i]);
                verifReponse.add(PionReponse[uneligne][i]);
            }
        }
        for (int j = 0; j < verifReponse.size(); j++) {

            for (int i = 0; i < verifJeu.size(); i++) {
                if (verifReponse.get(j).lireCouleur() == verifJeu.get(i).lireCouleur()) {
                    jetonBonneCouleur++;
                    verifReponse.remove(j);
                    verifJeu.remove(i);
                }
            }
        }
        return result;
    }

    public boolean verifNb(int number) {
        while (number > 0) {
            int remainder = number % 10;

            if (remainder == 9) {
                return false;
            }
            number = number / 10;
        }
        return true;
    }

    public String convertion(int x) {
        String str_x = String.valueOf(x);
        return (str_x);
    }
 
}
