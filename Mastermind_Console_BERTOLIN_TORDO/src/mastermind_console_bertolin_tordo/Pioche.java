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
    
    public void ajouterPion(Pion unPion){
        
        if(unPion.lireCouleur()=="Rouge"){
            couleurRouge.add(unPion);
        }
        else if(unPion.lireCouleur()=="Jaune"){
            couleurJaune.add(unPion);
        }
        else if(unPion.lireCouleur()=="Vert"){
            couleurVert.add(unPion);
        }
        else if(unPion.lireCouleur()=="Bleu"){
            couleurBleu.add(unPion);
        }
        else if(unPion.lireCouleur()=="Orange"){
            couleurOrange.add(unPion);
        }
        else if(unPion.lireCouleur()=="Violet"){
            couleurViolet.add(unPion);
        }
        else if(unPion.lireCouleur()=="Rose"){
            couleurRose.add(unPion);
        }
        else if(unPion.lireCouleur()=="Blanc"){
            couleurBlanc.add(unPion);
        }
    }
    
    public Pion choisirPion(String uneCouleur){
        if(uneCouleur=="Rouge"){
            return couleurRouge.remove(0);
        }
        else if(uneCouleur=="Jaune"){
            return couleurJaune.remove(0);
        }
        else if(uneCouleur=="Vert"){
            return couleurVert.remove(0);
        }
        else if(uneCouleur=="Bleu"){
            return couleurBleu.remove(0);
        }
        else if(uneCouleur=="Orange"){
            return couleurOrange.remove(0);
        }
        else if(uneCouleur=="Violet"){
           return couleurViolet.remove(0);
        }
        else if(uneCouleur=="Rose"){
            return couleurRose.remove(0);
        }
        else if (uneCouleur=="Blanc"){
            return couleurBlanc.remove(0);
        }
        else{
            return null;
        }
    }
    
}
