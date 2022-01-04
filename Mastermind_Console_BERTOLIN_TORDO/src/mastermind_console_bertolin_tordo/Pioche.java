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

    ArrayList<Pion> couleurRouge = new ArrayList<>();
    ArrayList<Pion> couleurJaune = new ArrayList<>();
    ArrayList<Pion> couleurVert = new ArrayList<>();
    ArrayList<Pion> couleurBleu = new ArrayList<>();
    ArrayList<Pion> couleurGris = new ArrayList<>();
    ArrayList<Pion> couleurTurquoise = new ArrayList<>();
    ArrayList<Pion> couleurFushia = new ArrayList<>();
    ArrayList<Pion> couleurNoir = new ArrayList<>();
    ArrayList<Pion> reponse = new ArrayList<>();

    public void ajouterPion(Pion unPion) {

        if ("Rouge".equals(unPion.lireCouleur())) {
            couleurRouge.add(unPion);
        } else if ("Jaune".equals(unPion.lireCouleur())) {
            couleurJaune.add(unPion);
        } else if ("Vert".equals(unPion.lireCouleur())) {
            couleurVert.add(unPion);
        } else if ("Bleu".equals(unPion.lireCouleur())) {
            couleurBleu.add(unPion);
        } else if ("Gris".equals(unPion.lireCouleur())) {
            couleurGris.add(unPion);
        } else if ("Turquoise".equals(unPion.lireCouleur())) {
            couleurTurquoise.add(unPion);
        } else if ("Fushia".equals(unPion.lireCouleur())) {
            couleurFushia.add(unPion);
        } else if ("Noir".equals(unPion.lireCouleur())) {
            couleurNoir.add(unPion);
        }
    }

    public void ajouterPion_reponse(Pion unPion) {

        if ("Rouge".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Jaune".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Vert".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Bleu".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Gris".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Turquoise".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Fushia".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        } else if ("Noir".equals(unPion.lireCouleur())) {
            reponse.add(unPion);
        }
    }

    public Pion choisirPion(String uneCouleur) {
        if (null == uneCouleur) {
            return null;
        } else {
            return switch (uneCouleur) {
                case "Rouge" ->
                    couleurRouge.remove(0);
                case "Jaune" ->
                    couleurJaune.remove(0);
                case "Vert" ->
                    couleurVert.remove(0);
                case "Bleu" ->
                    couleurBleu.remove(0);
                case "Gris" ->
                    couleurGris.remove(0);
                case "Turquoise" ->
                    couleurTurquoise.remove(0);
                case "Fushia" ->
                    couleurFushia.remove(0);
                case "Noir" ->
                    couleurNoir.remove(0);
                default ->
                    null;
            };
        }
    }

}
