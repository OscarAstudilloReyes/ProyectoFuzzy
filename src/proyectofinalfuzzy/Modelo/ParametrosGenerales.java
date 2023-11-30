/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalfuzzy.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Tatiana Astudillo
 */
public class ParametrosGenerales {

    private String parametro1;
    private String parametro2;
    private String parametro3;
    private String parametro4;
    private String carpetaData = "Data";
    private String rutaArchivos = "datosParametrosGenerales.txt";

    public String getParametro1() {
        return parametro1;
    }

    public void setParametro1(String parametro1) {
        this.parametro1 = parametro1;
    }

    public String getParametro2() {
        return parametro2;
    }

    public void setParametro2(String parametro2) {
        this.parametro2 = parametro2;
    }

    public String getParametro3() {
        return parametro3;
    }

    public void setParametro3(String parametro3) {
        this.parametro3 = parametro3;
    }

    public String getParametro4() {
        return parametro4;
    }

    // Modelo
    public void setParametro4(String parametro4) {
        this.parametro4 = parametro4;
    }

    public ParametrosGenerales() {
    }
    
      public ParametrosGenerales(String parametro1, String parametro2, String parametro3, String parametro4) {
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
        this.parametro3 = parametro3;
        this.parametro4 = parametro4;
    }


       // Método para crear una carpeta si no existe
    private void crearCarpetaSiNoExiste(String carpeta) {
        File folder = new File("src/"+carpeta);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }
    
    public boolean guardarInformacion() {
        crearCarpetaSiNoExiste(carpetaData);
        boolean exito = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/"+carpetaData+"/"+rutaArchivos, true))) {
            writer.write(parametro1 + "," + parametro2 + "," + parametro3 + "," + parametro4);
            writer.newLine();
            exito = true;
        } catch (IOException e) {
            e.printStackTrace();
            exito = false;
        }
        return exito;
    }

    public List<String> leerInformacion() {
        List<String> informacion = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/"+carpetaData+"/"+rutaArchivos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                informacion.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return informacion;
    }

}
