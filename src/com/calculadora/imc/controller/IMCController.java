
package com.calculadora.imc.controller;

import com.calculadora.imc.model.CalculadoraIMC;
import com.calculadora.imc.view.VistaCalculadora;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author María Dolores Barba López
 */

public class IMCController {
    private final VistaCalculadora vista;  
    private final  CalculadoraIMC calculadora = new CalculadoraIMC();
    
    
    public IMCController(VistaCalculadora vista){
        this.vista = vista;
    }
    
    public void btnCalcular(){
      String pesoKG = vista.txtPeso.getText().trim();
      String alturaCM = vista.txtAltura.getText().trim();
      
      double peso;
      double altura;
      try{
          peso = Double.parseDouble(pesoKG);
          altura = Double.parseDouble(alturaCM);
          if(peso <= 0 || altura <= 0){
              vista.lblClasificacion.setText("Erros, los datos deben se mayo que 0");
          }
        }catch(NumberFormatException e){
            vista.lblClasificacion.setText("Error, datos inválidos");
            return;
        }
      
      double imc = calculadora.calcular(peso, altura);
      String clasificacion = calculadora.clasificar(imc);
      
      vista.lblResultado.setText(String.format("Tu IMC es: %.2f", imc));
      vista.lblClasificacion.setText("Clasificacion: " + clasificacion);
    }
      
}

