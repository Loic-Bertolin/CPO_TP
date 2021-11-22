/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class Jeton {

    String Couleur;

    public Jeton(String unCouleur) {
        Couleur = unCouleur;
    }

    public String lireCouleur() {
            return Couleur;
        }
    
    @Override
    public String toString(){
        if ("Rouge".equals(Couleur)){
            return "\u001B[31m R";
        }
        else{
            return "\u001B[33m J";
        }
    } 
}
