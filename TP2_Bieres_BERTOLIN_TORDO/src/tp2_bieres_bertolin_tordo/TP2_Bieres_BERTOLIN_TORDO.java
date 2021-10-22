/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_bieres_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class TP2_Bieres_BERTOLIN_TORDO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls", 7.0 ,"Dubisson");
        uneBiere.lireEtiquette();
   
        BouteilleBiere autreBiere = new BouteilleBiere("Leffe", 6.6 ,"Abbaye de Leffe") ;
        autreBiere.lireEtiquette();
        
        BouteilleBiere autrebisBiere = new BouteilleBiere("BMB Bleue", 5.8 ,"Brasserie Mont Blanc") ;
        autrebisBiere.lireEtiquette();
        
    }
}
