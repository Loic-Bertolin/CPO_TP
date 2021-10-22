/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_bieres_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class BouteilleBiere {
String nom ;
double degreAlcool;
String brasserie;
boolean ouverte; //on creer les variables

    public BouteilleBiere(String unNom, double unDegre, String uneBrasserie) {
        nom = unNom;
        degreAlcool = unDegre;
        brasserie = uneBrasserie;
        ouverte = false;
    }
    public void lireEtiquette() { //foction lire l etiquette de la biere
        System.out.println("Bouteille de " + nom + " (" + degreAlcool + " degres) \nBrasserie : " + brasserie);

    }
    public void Décapsuler() { //fonction qui decapsule
        if (ouverte==false){
            ouverte=true;
        }
        else{
            System.out.println("erreur");
        }
    }
}
