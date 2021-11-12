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
public class Personne {

    String Nom;
    String Prenom;//on creer les variables
    int nbVoitures = 0;
    Voiture[] liste_voitures;

    public Personne(String unNom, String unPrenom) {
        Nom = unNom;
        Prenom = unPrenom;
        liste_voitures = new Voiture[3]; // création d'un tableau 3 cases (car 3 voitures max)
    }

    public boolean ajouter_voiture(Voiture voiture_a_ajouter) {
     boolean x = true;
     if (nbVoitures == 3){
         x = false;
     }
     if (voiture_a_ajouter.Proprietaire != null){
         x = false;
     }
     liste_voitures[nbVoitures] = voiture_a_ajouter;
     nbVoitures ++;
     voiture_a_ajouter.Proprietaire = this ;
     return x;
    }
}
