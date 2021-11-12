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
    Cellule[][]CellulesJeu = new Cellule[6][7];
    
    public Grille(){
        for(int lignes=0;lignes<6;lignes++){
            for(int colonnes= 0; colonnes<7; colonnes++){
                CellulesJeu[lignes][colonnes]=null;
            }
        }
    }
    public boolean ajouterJetonDansColonne(Jeton unJeton, int unecolonne){
        int lignes = 0;
        do{
            if(CellulesJeu[lignes][unecolonne]!=null){
                lignes++;  
            }
        }while(CellulesJeu[lignes][unecolonne]!=null);
        return CellulesJeu[lignes][unecolonne].affecterJeton(unJeton);
    }
    public boolean etreRemplie(){
        for(int lignes=0;lignes<6;lignes++){
            for(int colonnes= 0; colonnes<7; colonnes++){
                if(CellulesJeu[lignes][colonnes]!=null){
                    return false;
                }
            }
        }
        return true;
    }
    public void viderGrille(){
        for(int lignes=0;lignes<6;lignes++){
            for(int colonnes= 0; colonnes<7; colonnes++){
                CellulesJeu[lignes][colonnes]=null;  
            }
        }
    }
    public void afficherGrilleSurConsole(){
        
    }
    public boolean celluleOccupee(int uneligne, int unecolonne){
        return CellulesJeu[uneligne][unecolonne]!=null;
    
    }
    public String lireCouleurDuJeton(int uneligne, int unecolonne){
        return CellulesJeu[uneligne][unecolonne].lireCouleurDuJeton();
    }
    public boolean etreGagnantePourJoueur(){
        
    }
    public void tasserGrille(int unecolonne){ 
        int lignes = 0;
        do{
            if(CellulesJeu[lignes][unecolonne]!=null){
                lignes++;
            }
            // reste à faire décaler tout les jetons vers le bas quand on a trouvé la case
            // reste à faire etreGagnantePourJoueur et afficherGrilleSurConsole
        }while(lignes!=6);
    }
    public boolean colonneRemplie(int unecolonne){
        for(int lignes= 0; lignes<6; lignes++){
            if(CellulesJeu[lignes][unecolonne]==null){
                return false;
            }
        }
        return true;
    }
    public boolean placerTrouNoir(int uneligne, int unecolonne){
        return CellulesJeu[uneligne][unecolonne].placerTrouNoir();   
    }
    public boolean placerDesintegrateur(int uneligne, int unecolonne){
        return CellulesJeu[uneligne][unecolonne].placerDesintegrateur();
    }
    public boolean supprimerJeton(int uneligne, int unecolonne){
        return CellulesJeu[uneligne][unecolonne].supprimerJeton();
    }
    public Jeton recupererJeton(int uneligne, int unecolonne){
        return CellulesJeu[uneligne][unecolonne].recupererJeton();
    }
}
