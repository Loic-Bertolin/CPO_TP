/*
* TP1 Syntaxe de Base - Statistiques
* TORDO
* BERTOLIN
* 4/10/2021
*/
package tp1_stats_bertolin_tordo;

import java.util.Random;
import java.util.Scanner;

/**
*
* @author loicb
*/
public class TP1_stats_BERTOLIN_TORDO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float tab[ ] = new float[6];
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Saisissez le nombre de lancé de dé ");
        int m = sc.nextInt();
        float var = 0;
        float face1 = 0;
        float face2 = 0;
        float face3 = 0;
        float face4 = 0;
        float face5 = 0;
        float face6 = 0;
        
        
        while (var!=m){
            Random generateurAleat = new Random();
            int n = generateurAleat.nextInt(6);
            //System.out.println(n);
            if (n == 0){
              face1++;
            }
            if (n == 1){
              face2++;
            }
            if (n == 2){
              face3++;
            }
            if (n == 3){
              face4++;
            }
            if (n == 4){
              face5++;
            }
            if (n == 5){
              face6++;
            }
        var++;
        }
        tab[0] = (face1*100)/m;
        tab[1] = (face2*100)/m;
        tab[2] = (face3*100)/m;
        tab[3] = (face4*100)/m;
        tab[4] = (face5*100)/m;
        tab[5] = (face6*100)/m;
      System.out.println("\n La face avec le 1 est apparu " + tab[0] + " %");
      System.out.println("\n La face avec le 2 est apparu " + tab[1] + " %");
      System.out.println("\n La face avec le 3 est apparu " + tab[2] + " %");
      System.out.println("\n La face avec le 4 est apparu " + tab[3] + " %");
      System.out.println("\n La face avec le 5 est apparu " + tab[4] + " %");
      System.out.println("\n La face avec le 6 est apparu " + tab[5] + " %");
    }
    
}
