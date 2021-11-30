/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind_console_bertolin_tordo;

import java.util.ArrayList;

/**
 *
 * @author pierre
 */
public class Pioche {
    ArrayList<Pion> couleurRouge = new ArrayList<Pion>();
    ArrayList<Pion> couleurJaune = new ArrayList<Pion>();
    ArrayList<Pion> couleurVert = new ArrayList<Pion>();
    ArrayList<Pion> couleurBleu = new ArrayList<Pion>();
    ArrayList<Pion> couleurOrange = new ArrayList<Pion>();
    ArrayList<Pion> couleurViolet = new ArrayList<Pion>();
    ArrayList<Pion> couleurRose = new ArrayList<Pion>();
    ArrayList<Pion> couleurBlanc = new ArrayList<Pion>();
    
    public void remplirArrayList(Pion unPion){
        unPion.lireCouleur();
    }
    
}
