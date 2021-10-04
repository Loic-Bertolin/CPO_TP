/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_manipnombresint;

import java.util.Scanner;

/*TP1 Syntaxe de base-manipNombreInt
 *04/10/2021
 *BERTOLIN Loïc
 *TORDO Pierre
 */
public class TP1_manipNombresInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Variable 1 : ");
        int var1 = sc.nextInt();
        System.out.println("Variable 2 : ");
        int var2 = sc.nextInt();
        System.out.println("Les nombres sont " + var1 + " et " + var2);
        System.out.println("La somme est " + (var1 + var2));
        System.out.println("La différence est " + (var1-var2));
        System.out.println("Le produit est " + (var1*var2));
        System.out.println("La division est " + (var1/var2));
        System.out.println("Le quotient est " + (var1/var2) + "et le reste est" + (var1%var2));
    }
    
}
