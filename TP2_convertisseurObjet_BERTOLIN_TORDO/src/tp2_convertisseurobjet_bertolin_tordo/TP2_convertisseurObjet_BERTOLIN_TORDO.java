/*
* TP2 convertisseurObejet
* TORDO
* BERTOLIN
* 22/10/2021
 */
package tp2_convertisseurobjet_bertolin_tordo;

import java.util.Scanner;

/**
 *
 * @author loicb
 */
public class TP2_convertisseurObjet_BERTOLIN_TORDO {

    public static void main(String[] args) {
        // TODO code application logic here

        Convertisseur a = new Convertisseur();
        /*
        Convertisseur b = new Convertisseur();
        
        a.FarenheitVersCelcius(12);
        b.FarenheitVersCelcius(12);
        a.KelvinVersCelcius(12);
        
        System.out.println("Le nombre de conversion de a est : " + a.nbConversions + " et de b est : " + b.nbConversions);
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("1) CelciusVersKelvin");
        System.out.println("2) KelvinVersCelcius");
        System.out.println("3) FarenheitVersCelcius");
        System.out.println("4) CelciusVersFarenheit");
        System.out.println("5) KelvinVersFarenheit");
        System.out.println("6) FarenheitVersKelvin");
        System.out.println(" Bonjour, quelle conversion ?");
        int nb1 = sc.nextInt();
        while (nb1 > 6 || nb1 < 1) {
            System.out.println("ERREUR La valeur n'est pas comprise entre 1 et 6");
            System.out.println("\n Entrer un nombre :");
            nb1 = sc.nextInt(); //boucle tant que nb1 (1 a 6) n est pas associe a un programme
        }
        System.out.println(" Bonjour, quelle température ?");
        double temp = sc.nextDouble();
        switch (nb1) {
            case 1 -> {
                // CelciusVersKelvin
                System.out.println("La température en Kelvin est : " + a.CelciusVersKelvin(temp));
            }
            case 2 -> {
                //KelvinVersCelcius
                System.out.println("La température en Celcius est : " + a.KelvinVersCelcius(temp));
            }
            case 3 -> {
                //FarenheitVersCelcius
                System.out.println("La température en Celcius est : " + a.FarenheitVersCelcius(temp));
            }
            case 4 -> {
                //CelciusVersFarenheit
                System.out.println("La température en Fareinheit est : " + a.CelciusVersFarenheit(temp));
            }
            case 5 -> {
                //KelvinVersFarenheit
                System.out.println("La température en Fareinheit est : " + a.KelvinVersFarenheit(temp));
            }
            case 6 -> {
                //FarenheitVersKelvin
                System.out.println("La température en Kelvin est : " + a.FarenheitVersKelvin(temp));
            }

        }

    }
}
