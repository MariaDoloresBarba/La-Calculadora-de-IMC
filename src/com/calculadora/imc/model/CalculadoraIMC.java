
package com.calculadora.imc.model;

/**
 *
 * @author María Dolores Barba López
 */
public class CalculadoraIMC {
    double peso;
    double altura;
    double imc;
    String kilos;
    
    public double calcular(double peso, double altura){
        imc = peso / (altura*altura);
        return imc;
    }
    
    public String clasificar(double imc){
        if(imc < 18.5){
            kilos = "Bajo peso";
        } else if(imc <= 24.9){
            kilos = "Peso Normal";
        }else if(imc <= 29.9){
            kilos = "Sobrepeso";
        }else{
            kilos = "Obesidad";
        }
        return kilos;
    }
}
