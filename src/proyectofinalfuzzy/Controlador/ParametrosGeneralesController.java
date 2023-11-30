/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalfuzzy.Controlador;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyectofinalfuzzy.Modelo.ParametrosGenerales;
import proyectofinalfuzzy.Vista.FrmListadoParametrosGenerales;
import proyectofinalfuzzy.Vista.FrmParametrosGenerales;

/**
 *
 * @author Tatiana Astudillo
 */
public class ParametrosGeneralesController {
    private ParametrosGenerales modelo;

    
    
        public boolean guardarInformacion(FrmParametrosGenerales vista) {
        modelo = new ParametrosGenerales(vista.txtParametro1.getText(),vista.txtParametro2.getText(),vista.txtParametro3.getText(),vista.txtParametro4.getText());
        return modelo.guardarInformacion();
    }
        
        
        public List<String>  mostrarInformacionEnPaneles() {
        modelo = new ParametrosGenerales();
        return modelo.leerInformacion();
        //crearPanelesDinamico(informacion, vista);
    }
        
        
        
        public void crearPanelesDinamico(List<String> informacion,FrmListadoParametrosGenerales vista) {
        //vista.getContentPane().removeAll();  // Elimina cualquier componente existente
        for (String linea : informacion) {
            JPanel panel = crearPanelParaFila(linea);
            vista.add(panel);
        }
        vista.revalidate();
        vista.repaint();
        vista.setVisible(true);
        vista.setLayout(null);
    }

    // Método para crear un panel para una fila de datos
    private JPanel crearPanelParaFila(String linea) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());  // O cualquier otro diseño que prefieras
        panel.setBackground(Color.BLUE);
        // Dividir la línea en partes usando la coma como delimitador
        String[] partes = linea.split(",");
        for (String parte : partes) {
            JLabel etiqueta = new JLabel(parte);
            panel.add(etiqueta);
        }
        panel.setBounds(50, 100, 200, 100); // ajusta las coordenadas y dimensiones según tus necesidades
        return panel;
        
        

    }

        
}
