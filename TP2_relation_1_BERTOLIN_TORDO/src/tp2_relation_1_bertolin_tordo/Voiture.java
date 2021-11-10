/*
* TP2 Biere
* TORDO
* BERTOLIN
* 22/10/2021
*/
package tp2_relation_1_bertolin_tordo;

/**
 *
 * @author pierre
 */
public class Voiture {
    String Modele;
    String Marque;
    int PuissanceCV;//on creer les variables
    
    public Voiture (String unModele, String uneMarque, int unePuissanceCV){
        Modele = unModele;
        Marque = uneMarque;
        PuissanceCV = unePuissanceCV;
        
    }
    @Override
    public String toString() {
        String chaine;
        chaine = "Modele " + Modele + "\n" + " Marque " + Marque + " PuissanceCV " + PuissanceCV;
        return chaine;
    }
}
