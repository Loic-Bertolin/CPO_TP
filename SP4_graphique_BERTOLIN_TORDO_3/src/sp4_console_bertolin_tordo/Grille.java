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

boolean ajouterJetonDansColonne(Jeton unJeton, int ind_colonne) {
        for (int i = 0; i < 6; i++) {
            if (CellulesJeu[i][ind_colonne].affecterJeton(unJeton) == true) {
                return true;
            }
        }
        return false;
    
    
    
        /* // si la colonne est remplie, on s'arrete et on retourne false
        if (colonneRemplie(ind_colonne)){
            return false;
        }
        
        // on recherche l'indice de la ligne où ajouter le jeton
        // forcement cet indice existe 
        int i = 0;
        while (CellulesJeu[i][ind_colonne].jetonCourant != null) {
            i++;
        }

        // on récupére un jeton dans la liste des jetons du joueur 
        Jeton un_jeton = joueurCourant.retirerJeton();
        // on ajoute le jeton dans la case en question
        CellulesJeu[i][ind_colonne].jetonCourant = un_jeton;
        // on récupère un potentiel désintegrateur
        if (CellulesJeu[i][ind_colonne].presenceDesintegrateur()) {
            CellulesJeu[i][ind_colonne].recupererDesintegrateur();
            joueurCourant.nombreDesintegrateurs++;
        }
        // on active le potentiel trou noir
        if (CellulesJeu[i][ind_colonne].presenceTrouNoir()) {
           CellulesJeu[i][ind_colonne].activerTrouNoir();
        }
        return true;*/
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
                CellulesJeu[lignes][colonnes].desintegrateur = false;
                CellulesJeu[lignes][colonnes].trouNoir = false;
            }
        }
    }

    public void afficherGrilleSurConsole() {
        System.out.print("\n" + "|");
        for (int lignes = 5; lignes >= 0; lignes--) {
            for (int colonnes = 0; colonnes < 7; colonnes++) {
                if ("Rouge".equals(CellulesJeu[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("R|");
                } else if ("Jaune".equals(CellulesJeu[lignes][colonnes].lireCouleurDuJeton())) {
                    System.out.print("J|");
                } else if (CellulesJeu[lignes][colonnes].presenceTrouNoir() == true) {
                    System.out.print("N|");
                } else if (CellulesJeu[lignes][colonnes].presenceDesintegrateur() == true) {
                    //if(CellulesJeu[lignes][colonnes].presenceTrouNoir()==true){

                    // }
                    System.out.print("D|");
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
                        int compteur = 0;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes][colonnes + compteur].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 3) {
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
                        int compteur = 0;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes + compteur][colonnes].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 3) {
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
                        int compteur = 0;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes + compteur][colonnes + compteur].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 3) {
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
                        int compteur = 0;
                        while (CellulesJeu[lignes][colonnes].lireCouleurDuJeton() == CellulesJeu[lignes - compteur][colonnes + compteur].lireCouleurDuJeton()) {
                            compteur++;
                            if (compteur == 3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    

    void tasserGrille() {
        for (int i = 0; i <7;i++){
            tasserColonne(i);
        }
        
        /*int lignes = 0;
        while (CellulesJeu[lignes][unecolonne].jetonCourant != null) {
                lignes++;
            
        }
        for (int i = lignes; i < 5; i++) {
            CellulesJeu[i][unecolonne].jetonCourant = CellulesJeu[i + 1][unecolonne].jetonCourant;
            CellulesJeu[i+1][unecolonne].jetonCourant = null;
        }
        CellulesJeu[5][unecolonne].jetonCourant = null;*/
    }
    
        void tasserColonne (int colonne){
        for (int i = 0; i<6;i++){
            if(i==5){
                CellulesJeu[i][colonne].jetonCourant = null;
            }
            else{
                if (CellulesJeu[i][colonne].jetonCourant == null){
                    CellulesJeu[i][colonne].jetonCourant = CellulesJeu[i+1][colonne].jetonCourant;
                    CellulesJeu[i+1][colonne].jetonCourant = null;
                }
            }
        }
    }
    

    public boolean colonneRemplie(int unecolonne) {
        /*for (int lignes = 0; lignes < 6; lignes++) {
            if (CellulesJeu[lignes][unecolonne] == null) {
                return false;
            }
        }
        return true;*/
        return(CellulesJeu[4][unecolonne].jetonCourant!=null);
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
