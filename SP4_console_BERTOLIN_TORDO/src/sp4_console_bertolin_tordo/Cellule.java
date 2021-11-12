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
    
    public Cellule(){
        jetonCourant=null;
        trouNoir=false;
        desintegrateur=false;
    }
    public boolean affecterJeton(Jeton unJeton){
        if (jetonCourant==null){
            jetonCourant=unJeton;
            return true;
        }
        else{
            return false;
        }
    }
}
