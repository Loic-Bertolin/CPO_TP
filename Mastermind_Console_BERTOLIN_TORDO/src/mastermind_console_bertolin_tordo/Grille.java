/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

import java.util.ArrayList;

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

    public boolean ajouterPionDansLigne(Pion unPion, int uneLigne) {
        for (int i = 0; i < 12; i++) {
            if (PionJeu[uneLigne][i] == null) {
                PionJeu[uneLigne][i] = unPion;
                return true;
            }
        }
        return false;
    }

    public boolean etreRemplie() {
        for (int lignes = 0; lignes < 12; lignes++) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                if (PionJeu[lignes][colonnes] != null) {
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

    public void afficherGrilleSurConsole() {
        System.out.print("\n" + "|");
        for (int lignes = 12; lignes >= 0; lignes--) {
            for (int colonnes = 0; colonnes < 4; colonnes++) {
                if ("Rouge".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("R|");
                } else if ("Jaune".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("J|");
                } else if ("Vert".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("V|");
                } else if ("Bleu".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("B|");
                } else if ("Orange".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("O|");
                } else if ("Marron".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("M");
                } else if ("Fushia".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("F|");
                } else if ("Noir".equals(PionJeu[lignes][colonnes].lireCouleur())) {
                    System.out.print("N|");
                } else {
                    System.out.print("-|");
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

    public String lireCouleurPion(int uneligne, int unecolonne) {
        return PionJeu[uneligne][unecolonne].lireCouleur();
    }

    public boolean etreGagnantPourJoueur() {
        return verifierLigne(derniereLigneRemplie)[0]==4;
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

}
