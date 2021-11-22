/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class Joueur {

    String Nom;
    String Couleur;
    Jeton[] ListeJetons = new Jeton[21];
    int nombreJetonRestants = 0;
    int nombreDesintegrateurs = 0;

    public  Joueur(String unNom) {
        Nom = unNom;
    }

    public void affecterCouleur(String uneCouleur) {
        Couleur = uneCouleur;
    }

    public boolean ajouterJeton(Jeton unJeton) {
        int i = 0;
        do {
            if (ListeJetons[i] != null) {
                i++;
            if (i==21){
                return false;
            }
            }
        } while (ListeJetons[i] != null);
        ListeJetons[i] = unJeton;
        return true;
    }

    public void obtenirDesintegrateur() {
        nombreDesintegrateurs++;
    }
    
    public boolean utiliserDesintegrateur() {
        if (nombreDesintegrateurs==0){
            return false;
        }
        else{
            nombreDesintegrateurs=nombreDesintegrateurs-1;
            return true;
        }
    }
}
