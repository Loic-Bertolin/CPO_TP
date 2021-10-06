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
        Scanner sc = new Scanner(System.in);
        Random generateurAleat = new Random();

        System.out.println("Choisir la difficulté");
        System.out.println("1) Facile");
        System.out.println("2) Normal");
        System.out.println("3) Difficile");
        int diff = sc.nextInt();
        while (diff > 3 || diff < 1) {
            System.out.println("ERREUR La valeur n'est pas comprise entre 1 et 3");
            System.out.println("Choisir la difficulté");
            diff = sc.nextInt();
        }
        int x = 100;
        int max = 100;
        switch (diff) {
            case 1 -> {
                System.out.println("tu as 100 coups pour trouver le nombre");
            }
            case 2 -> {
                max = 5;
                System.out.println("tu as 5 coups pour trouver le nombre");
            }
            case 3 -> {
                x = 10000;
                max = 20;
                System.out.println("tu as 20 coups pour trouver le nombre");

            }
        }

        int alea = generateurAleat.nextInt(x);

        System.out.println("Entre 0 et " + x + " : ");
        int nb = sc.nextInt();

        int z = 1;
        do {
            if (max == 0) {
                System.out.println("Tu n'as plus de coup");
                break;
            }
            if (nb < alea) {
                System.out.println("trop petit");
                nb = sc.nextInt();
            }
            if (nb > alea) {
                System.out.println("trop grand");
                nb = sc.nextInt();
            }
            z++;
            max -= 1;
        } while (nb != alea);
        if (nb == alea) {
            System.out.println(
                    "exact en " + z + " coups");
        }
    }

}


