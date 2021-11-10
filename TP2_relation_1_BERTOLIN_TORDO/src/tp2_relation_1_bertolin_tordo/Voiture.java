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
    Personne Proprietaire = null;
    int PuissanceCV;//on creer les variables
    
    public Voiture (String unModele, String uneMarque, int unePuissanceCV){
        Modele = unModele; // affection du nom à l'objet
        Marque = uneMarque;
        PuissanceCV = unePuissanceCV;
        //Proprietaire = this;
    }
    @Override
    public String toString() {
        String chaine;
        chaine = "\n" +"Modele: " + Modele + "\n" + " Marque: " + Marque + "\n" +" PuissanceCV: " + PuissanceCV;
        return chaine;
    }
}
