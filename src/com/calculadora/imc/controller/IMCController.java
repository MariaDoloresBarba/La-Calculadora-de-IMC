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
      String pesoKG = vista.getTxtPeso().getText().trim();
      String alturaCM = vista.getTxtAltura().getText().trim();
      
      pesoKG = pesoKG.replace(',', '.'); //Es mejor el punto porque la coma se usa como carácter espcial en algunas funciones de java.
      alturaCM = alturaCM.replace(',', '.');
      
      double peso;
      double altura;
      try {
          peso = Double.parseDouble(pesoKG);
          altura = Double.parseDouble(alturaCM);
          
          if(peso <= 0 || altura <= 0){
              vista.getLblResultado().setText("IMC: ");
              vista.getLblClasificacion().setText("Error, los datos deben ser mayores que 0");
              vista.getLblClasificacion().setForeground(Color.red);
              return; 
            }
        } catch(NumberFormatException e) {
          vista.getLblResultado().setText("IMC: ");
          vista.getLblClasificacion().setText("Error, datos inválidos");
          vista.getLblClasificacion().setForeground(Color.red);
          return;
      }
      
      double imc = calculadora.calcular(peso, altura);
      String clasificacion = calculadora.clasificar(imc);
      
      vista.getLblResultado().setText(String.format("Tu IMC es: %.2f", imc));
      vista.getLblClasificacion().setText("Clasificación: " + clasificacion);
      
      colorPeso(clasificacion);
    }

    private void colorPeso(String clasificacion){
        switch(clasificacion){
            case "Peso Normal":
                vista.getLblClasificacion().setForeground(Color.green);
                break;
            case "Bajo Peso":
                vista.getLblClasificacion().setForeground(Color.orange);
                break;
            case "Sobrepeso":
                vista.getLblClasificacion().setForeground(Color.orange);
                break;
            case "Obesidad":
                vista.getLblClasificacion().setForeground(Color.red);
                break;
            default:
                vista.getLblClasificacion().setForeground(Color.black);
                break;
        }
    }
}
