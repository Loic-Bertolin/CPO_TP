/*
* TP2 manip
* TORDO
* BERTOLIN
* 22/10/2021
 */
package tp2_manip_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class TP2_manip_BERTOLIN_TORDO {

    public static void main(String[] args) {
        // TODO code application logic here
        Tartiflette assiette1 = new Tartiflette(500);
        Tartiflette assiette2 = new Tartiflette(600);
        Tartiflette assiette3 = assiette2;
        assiette2 = assiette1;
        assiette1 = assiette3;

        System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);
        System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories);
        // 2 lignes fausses une tartiflette ne devient pas une moussaka
        // reponse question : non

        Moussaka tab[] = new Moussaka[10]; // tableau de moussaka vide de 10 places
        for (int i = 0; i < 9; i++) { //bloucle
            Moussaka a = new Moussaka(); //creeer des moussakas
            tab[i]=a; //le met dans le tableau
            System.out.println(tab[i]); //ppour comprendre le tableau
        }

    }

}
