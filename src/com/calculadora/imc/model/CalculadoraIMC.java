
package com.calculadora.imc.model;

/**
 *
 * @author María Dolores Barba López
 */
public class CalculadoraIMC {
    double peso;
    double altura;
    double imc;
    
    public double calcular(double peso, double altura){
        imc = peso / (altura*altura);
        return imc;
    }
    
    public Strin
}
