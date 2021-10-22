/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_convertisseurobjet_bertolin_tordo;

/**
 *
 * @author loicb
 */
public class Convertisseur {
    int nbConversions;
    public Convertisseur () {
        nbConversions = 0;
    }

    
    public double CelciusVersKelvin(double tempCelcius) {
        double tempKelvin = (double) (tempCelcius + 273.15);
        nbConversions+=1;
        return tempKelvin;
    }

    public double KelvinVersCelcius(double tempKelvin) {
        double tempCelcius = (double) (tempKelvin - 273.15);
        nbConversions+=1;

        return tempCelcius;
    }

    public double FarenheitVersCelcius(double tempFareinheit) {
        double tempCelcius = (double) ((tempFareinheit - 32) * 5 / 9);
        nbConversions+=1;
        return tempCelcius;
    }

    public double CelciusVersFarenheit(double tempCelcius) {
        double tempFareinheit = (double) ((tempCelcius * 9 / 5) + 32);
        nbConversions+=1;
        return tempFareinheit;
    }

    public double KelvinVersFarenheit(double tempKelvin) {
        double tempFareinheit = (double) ((tempKelvin - 273.15) * 9 / 5 + 32);
        nbConversions+=1;
        return tempFareinheit;
    }

    public double FarenheitVersKelvin(double tempFareinheit) {
        double tempKelvin = (double) ((tempFareinheit - 32) * 5 / 9 + 273.15);
        nbConversions+=1;
        return tempKelvin;
    }
    @Override
    public String toString() {
        return "nb de conversions"+nbConversions;
    }
}
