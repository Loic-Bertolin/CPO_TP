/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class Grille {

    Cellule[][] CellulesJeu = new Cellule[6][7];

    public Grille() {
        for (int lignes = 0; lignes < 6; lignes++) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                CellulesJeu[lignes][colonnes] = new Cellule();
            }
        }
    }

    public boolean ajouterJetonDansColonne(Jeton unJeton, int unecolonne) {
        for (int i=0;i<6;i++){
            if(CellulesJeu[i][unecolonne].affecterJeton(unJeton)==true){
                return true;
            }
        }
        return false;
    }

    public boolean etreRemplie() {
        for (int lignes = 0; lignes < 6; lignes++) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                if (CellulesJeu[lignes][colonnes] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void viderGrille() {
        for (int lignes = 0; lignes < 6; lignes++) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                CellulesJeu[lignes][colonnes].jetonCourant = null;
            }
        }
    }

    public void afficherGrilleSurConsole() {
        System.out.print("\n"+"|");
        for (int lignes = 5; lignes >=0; lignes--) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {              
                if ("Rouge".equals(CellulesJeu[lignes][colonnes].lireCouleurDuJeton())){
                    System.out.print("R|");
                }
                else if ("Jaune".equals(CellulesJeu[lignes][colonnes].lireCouleurDuJeton())){
                    System.out.print("J|");
                }
                else if (CellulesJeu[lignes][colonnes].presenceTrouNoir()==true){
                    System.out.print("N|");
                }
                else if (CellulesJeu[lignes][colonnes].presenceDesintegrateur()==true){
                    //if(CellulesJeu[lignes][colonnes].presenceTrouNoir()==true){
                        
                   // }
                    System.out.print("D|");
                }
                else{
                    System.out.print("-|");
                }
            }
            if (lignes>0){
            System.out.print("\n|");
            }
            else{
                System.out.println("");
            }
        }
    }

    public boolean celluleOccupee(int uneligne, int unecolonne) {
        return CellulesJeu[uneligne][unecolonne] != null;

    }

    public String lireCouleurDuJeton(int uneligne, int unecolonne) {
        return CellulesJeu[uneligne][unecolonne].lireCouleurDuJeton();
    }

    public boolean etreGagnantePourJoueur(Joueur unJoueur) {
        //verif lignes
        for (int lignes = 0; lignes < 5; lignes++) {
            for (int colonnes = 0; colonnes < 3; colonnes++) {
               
                if (CellulesJeu[lignes][colonnes].jetonCourant == null) {
                    colonnes++;
                } else {
                    String couleur = unJoueur.Couleur;
                    if (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() != couleur) {
                        colonnes++;
                    } else {
                        int compteur = 1;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes][colonnes + compteur].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 4) {
                                return true;
                            }
                        } 

                    }
                }
            }
        }
        //colonnes
        for (int lignes = 0; lignes < 2; lignes++) {
            for (int colonnes = 0; colonnes < 6; colonnes++) {
                if (CellulesJeu[lignes][colonnes].jetonCourant == null) {
                    colonnes++;
                } else {
                    String couleur = unJoueur.Couleur;
                    if (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() != couleur) {
                        colonnes++;
                    } else {
                        int compteur = 1;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes + compteur][colonnes].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 4) {
                                return true;
                            }
                        } 
                    }
                }
            }
        }
        //verif diag +
        for (int lignes = 0; lignes < 2; lignes++) {
            for (int colonnes = 0; colonnes < 3; colonnes++) {
                if (CellulesJeu[lignes][colonnes].jetonCourant == null) {
                    colonnes++;
                } else {
                    String couleur = unJoueur.Couleur;
                    if (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() != couleur) {
                        colonnes++;
                    } else {
                        int compteur = 1;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes + compteur][colonnes + compteur].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 4) {
                                return true;
                            }
                        } 
                    }
                }
            }
        }
        //verif diag -
        for (int lignes = 3; lignes < 5; lignes++) {
            for (int colonnes = 0; colonnes < 3; colonnes++) {
                if (CellulesJeu[lignes][colonnes].jetonCourant == null) {
                    colonnes++;
                } else {
                    String couleur = unJoueur.Couleur;
                    if (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() != couleur) {
                        colonnes++;
                    } else {
                        int compteur = 1;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes - compteur][colonnes + compteur].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 4) {
                                return true;
                            }
                        } 
                    }
                }
            }
        }
        return false;
    }

    public void tasserGrille(int unecolonne) {
        int lignes = 0;
        do {
            if (CellulesJeu[lignes][unecolonne].jetonCourant != null) {
                lignes++;
            }
        } while (CellulesJeu[lignes][unecolonne].jetonCourant != null);
        for (int i = lignes; i < 4; i++) {
            CellulesJeu[lignes][unecolonne].jetonCourant = CellulesJeu[lignes + 1][unecolonne].jetonCourant;
        }
        CellulesJeu[5][unecolonne].jetonCourant = null;
    }

    public boolean colonneRemplie(int unecolonne) {
        for (int lignes = 0; lignes < 6; lignes++) {
            if (CellulesJeu[lignes][unecolonne] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean placerTrouNoir(int uneligne, int unecolonne) {
        return CellulesJeu[uneligne][unecolonne].placerTrouNoir();
    }

    public boolean placerDesintegrateur(int uneligne, int unecolonne) {
        return CellulesJeu[uneligne][unecolonne].placerDesintegrateur();
    }

    public boolean supprimerJeton(int uneligne, int unecolonne) {
        return CellulesJeu[uneligne][unecolonne].supprimerJeton();
    }

    public Jeton recupererJeton(int uneligne, int unecolonne) {
        return CellulesJeu[uneligne][unecolonne].recupererJeton();
    }
}
