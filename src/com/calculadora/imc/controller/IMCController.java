
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
    private final JTextField txtPeso;
    private final JTextField txtAltura;
    private final JButton btnCalcular;
    private final JLabel lblResultado;
    private final JLabel lblClasificacion;
    
    private final  CalculadoraIMC calculadora = new CalculadoraIMC();
    
    private static final Color VERDE = Color.GREEN;
    private static final Color NARANJA = Color.ORANGE;
    private static final Color ROJO = Color.RED;
    
    public IMCController(VistaCalculadora vista){
        this.txtPeso = vista.getTxtPeso();
        this.txtAltura = vista.getTxtAltura();
        this.btnCalcular = vista.getBtnCalcular();
        this.lblResultado = vista.getLblResultado();
        this.lblClasificacion = vista.getLblClasificacion();
    }
}
