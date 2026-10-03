package com.calculadora.imc.controller;

import com.calculadora.imc.model.CalculadoraIMC;
import com.calculadora.imc.view.VistaCalculadora;
import java.awt.Color;


      /**
      *
      * @author María Dolores Barba López
      */


public class IMCController {
    private final VistaCalculadora vista;  
    private final CalculadoraIMC calculadora = new CalculadoraIMC();
    
    public IMCController(VistaCalculadora vista){
        this.vista = vista;
    }
    
    public void btnCalcular(){
      String pesoKG = vista.txtPeso.getText().trim();
      String alturaCM = vista.txtAltura.getText().trim();
      
      pesoKG = pesoKG.replace(',', '.');
      alturaCM = alturaCM.replace(',', '.');
      
      double peso;
      double altura;
      try {
          peso = Double.parseDouble(pesoKG);
          altura = Double.parseDouble(alturaCM);
          
          if(peso <= 0 || altura <= 0){
              vista.lblResultado.setText("IMC: ");
              vista.lblClasificacion.setText("Error, los datos deben ser mayores que 0");
              vista.lblClasificacion.setForeground(Color.red);
              return; 
            }
        } catch(NumberFormatException e) {
          vista.lblResultado.setText("IMC: ");
          vista.lblClasificacion.setText("Error, datos inválidos");
          vista.lblClasificacion.setForeground(Color.red);
          return;
      }
      
      double imc = calculadora.calcular(peso, altura);
      String clasificacion = calculadora.clasificar(imc);
      
      vista.lblResultado.setText(String.format("Tu IMC es: %.2f", imc));
      vista.lblClasificacion.setText("Clasificación: " + clasificacion);
      
      colorPeso(clasificacion);
    }

    private void colorPeso(String clasificacion){
        switch(clasificacion){
            case "Peso Normal":
                vista.lblClasificacion.setForeground(Color.green);
                break;
            case "Bajo Peso":
            case "Sobrepeso":
                vista.lblClasificacion.setForeground(Color.orange);
                break;
            case "Obesidad":
                vista.lblClasificacion.setForeground(Color.red);
                break;
            default:
                vista.lblClasificacion.setForeground(Color.black);
                break;
        }
    }
}
