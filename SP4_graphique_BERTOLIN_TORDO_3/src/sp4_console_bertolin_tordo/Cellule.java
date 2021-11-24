/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class Cellule {

    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;

    public Cellule() {
        jetonCourant = null;
        trouNoir = false;
        desintegrateur = false;
    }

    public boolean affecterJeton(Jeton unJeton) {
        if (jetonCourant != null) {
            return false; 
        } 
        else {
            jetonCourant=unJeton;
            activerTrouNoir();
            //if(recupererDesintegrateur()==true){
            //}
            return true;
        }
    }

    public Jeton recupererJeton() {
        return jetonCourant;
    }

    public boolean supprimerJeton() {
        if (jetonCourant == null) {
            return false;
        } else {
            jetonCourant = null;
            return true;
        }
    }

    public boolean placerTrouNoir() {
        if (trouNoir == false) {
            trouNoir = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean placerDesintegrateur() {
        if (desintegrateur == false) {
            desintegrateur = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean presenceTrouNoir() {
        return trouNoir;
    }

    public boolean presenceDesintegrateur() {
        return desintegrateur;

    }

    public String lireCouleurDuJeton() {
        if (jetonCourant == null) {
            return null;
        } 
        else {
            return jetonCourant.lireCouleur();
        }
    }

    public boolean recupererDesintegrateur() {
        if(desintegrateur==false){
            return false;
        }
        else{
            desintegrateur = false;
            return true;
        }
    }

    public boolean activerTrouNoir() {
        if(trouNoir==false){
            return false;
        }
        else{
            jetonCourant = null;
            trouNoir = false;
            return true;
        }
    }

}
