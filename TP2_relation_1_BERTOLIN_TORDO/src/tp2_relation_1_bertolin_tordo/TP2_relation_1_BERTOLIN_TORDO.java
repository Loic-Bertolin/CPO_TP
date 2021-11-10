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
public class TP2_relation_1_BERTOLIN_TORDO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Voiture uneClio = new Voiture ("Clio", "Renault", 5 ) ; // création d'un objet voiture 
        Voiture uneAutreClio = new Voiture ("Clio", "Renault", 5 ) ; 
        Voiture une2008 = new Voiture ("2008", "Peugeot", 6 ) ; 
        Voiture uneMicra = new Voiture ("Micra", "Nissan", 4 ) ; 
        
        Personne bob = new Personne("Bobby", "Sixkiller"); // création d'un objet Personne
        Personne reno = new Personne("Reno", "Raines"); 
        
        bob.liste_voitures[0] = uneClio ; 
        bob.liste_voitures[1] = uneMicra ;
        bob.liste_voitures[2] = une2008 ;
        bob.nbVoitures = 3 ; // nb de voiture possedé par bob
        uneClio.Proprietaire = bob ;// on affecte une voiture l'objet uneClio au propriétaire bob
        uneMicra.Proprietaire = bob ;
        une2008.Proprietaire = bob ;
        
        //System.out.println("liste des voitures disponibles "+ uneClio + "\n" + uneAutreClio + "\n" + une2008 + "\n" + uneMicra ) ;
        System.out.println("la premiere voiture de Bob est " + bob.liste_voitures[0] ); 
        System.out.println("la deuxième voiture de Bob est " +  bob.liste_voitures[1]); // affichage
        System.out.println("la troisième voiture de Bob est " +  bob.liste_voitures[2]);

    }

}
