/*
 * TP1 Syntaxe de Base - convertisseur
 * TORDO
 * BERTOLIN
 * 4/10/2021
 */
package tp1_guessmynumber_bertolin_tordo;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author loïc
 */
public class TP1_guessMyNumber_BERTOLIN_TORDO {

    public static void main(String[] args) {
        /*int n2=generateurAleat.nextInt(100);
        int n3=generateurAleat.nextInt(100);
        int n4=generateurAleat.nextInt(100);
        int n5=generateurAleat.nextInt(100);
        System.out.println(alea + " " + n2 + " " + n3 + " " + n4 + " " + n5 );*/
        Scanner sc = new Scanner(System.in); // on cree une biblio scanner
        Random generateurAleat = new Random(); //on cree une biblio aléatoire

        System.out.println("Choisir la difficulté");
        System.out.println("1) Facile");
        System.out.println("2) Normal");
        System.out.println("3) Difficile");
        int diff = sc.nextInt(); //demande pour choisir la difficulté du jeu
        while (diff > 3 || diff < 1) {
            System.out.println("ERREUR La valeur n'est pas comprise entre 1 et 3");
            System.out.println("Choisir la difficulté");
            diff = sc.nextInt(); //boucle tant que diff n est pas entre 1 et 3 afin d avoir un programme associe
        }
        int x = 100; //represente la valeur max que peut avoir 
        int max = 100; // represente la nombre de coup autorise pour faire le jeu
        switch (diff) {
            case 1 -> {
                System.out.println("tu as 100 coups pour trouver le nombre");
            }//facile
            case 2 -> {
                max = 5;
                System.out.println("tu as 5 coups pour trouver le nombre");
            }//moyen
            case 3 -> {
                x = 10000;
                max = 20;
                System.out.println("tu as 20 coups pour trouver le nombre");
            }//difficile
        }

        int alea = generateurAleat.nextInt(x); //cree un nombre alea entre 0 et X

        System.out.println("Entre 0 et " + x + " : ");
        int nb = sc.nextInt(); //entre un nombre

        int z = 1;
        do {
            if (max == 0) {
                System.out.println("Tu n'as plus de coup");
                break; //si max =0 il n y a plus de coup
            }
            if (nb < alea) {
                System.out.println("trop petit");
                nb = sc.nextInt(); //trop petit
            }
            if (nb > alea) {
                System.out.println("trop grand");
                nb = sc.nextInt(); //trop grand
            }
            z++; //nombre de coups
            max -= 1;//on enleve le droit de 1 coup
        } while (nb != alea); //tant que nb different de alea
        if (nb == alea) { //si c est juste
            System.out.println(
                    "exact en " + z + " coups");
        }
    }

}


