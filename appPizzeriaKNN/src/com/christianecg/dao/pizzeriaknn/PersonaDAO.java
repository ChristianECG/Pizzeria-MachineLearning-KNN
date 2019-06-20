package com.christianecg.dao.pizzeriaknn;

import com.christianecg.dato.pizzeriaknn.Persona;
import com.christianecg.interfaz.pizzeriaknn.InterfacePersona;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author christianecg
 */
public class PersonaDAO extends Persona implements InterfacePersona{

    Vector vectorPersona = new Vector();

    public PersonaDAO() {
        super();
    }
    
    @Override
    public void Guardar(Persona persona) {
        vectorPersona.addElement(persona);
    }

    @Override
    public DefaultTableModel listar() {
        Vector vectorListaPersonas = new Vector();
        vectorListaPersonas.addElement("Edad");
        vectorListaPersonas.addElement("Sexo");
        vectorListaPersonas.addElement("Pizza preferida");
        DefaultTableModel tblEstudiante = new DefaultTableModel(vectorListaPersonas,0);
        
        try {
            FileReader fileLeePersona = new FileReader("gustospizza.txt");
            BufferedReader bufReadPersona = new BufferedReader(fileLeePersona);
            String dato;
            while ((dato = bufReadPersona.readLine()) != null) {
                StringTokenizer linea = new StringTokenizer(dato,",");
                Vector lineaPersona = new Vector();
                while (linea.hasMoreTokens()) {                    
                    lineaPersona.addElement(linea.nextToken());
                }
            tblEstudiante.addRow(lineaPersona);    
            }
        } catch (java.io.IOException ioexlista) {
            JOptionPane.showMessageDialog(null, ioexlista.toString());
        }
        return tblEstudiante;
    }
    
    public void GuardarArchivo(Persona persona){
        try {
            FileWriter fileEscribePersona = new FileWriter("gustospizza.txt",true);
            BufferedWriter  bufWritEscribePersona = new BufferedWriter(fileEscribePersona);
            PrintWriter printWritEscribePersona = new PrintWriter(bufWritEscribePersona);
            
            printWritEscribePersona.print(persona.getEdad());
            printWritEscribePersona.print("," + persona.getSexo());
            printWritEscribePersona.println("," + persona.getPizza());
            printWritEscribePersona.close();
            
        } catch (java.io.IOException ioexarchivo) {
            JOptionPane.showMessageDialog(null, ioexarchivo.toString());
        }
    } 

    @Override
    public String[][] Leer(int edad, int sexo) {
        Vector distancias = new Vector(1, 1);
        Vector preferencias_pizzas = new Vector(1, 1);
        try {
            FileReader fileLeePersona = new FileReader("gustospizza.txt");
            BufferedReader bufReadPersona = new BufferedReader(fileLeePersona);
            String dato;
            while ((dato = bufReadPersona.readLine()) != null) {
                StringTokenizer linea = new StringTokenizer(dato,",");
                Vector lineaPersona = new Vector();
                while (linea.hasMoreTokens()) {                    
                    lineaPersona.addElement(linea.nextToken());
                }
                distancias.addElement(Math.sqrt(Math.pow(sexo-Integer.parseInt(lineaPersona.elementAt(1).toString()),2)+Math.pow(edad-Integer.parseInt(lineaPersona.elementAt(0).toString()),2)));
                preferencias_pizzas.addElement(lineaPersona.elementAt(2));
            }
            
            String lectura[][]=new String[distancias.size()][2];
            for(int i=0;i<distancias.size();i++){
                lectura[i][0]=String.valueOf(distancias.elementAt(i));
                lectura[i][1]=String.valueOf(preferencias_pizzas.elementAt(i));
            }
            
            return lectura;
            
        } catch (java.io.IOException ioexlista) {
            JOptionPane.showMessageDialog(null, ioexlista.toString());
            return null;
        }
    }
    
    public String[][] burbuja(String arreglo[][]){
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (Double.parseDouble(arreglo[j][0]) > Double.parseDouble(arreglo[j + 1][0])){
                    double tmp = Double.parseDouble(arreglo[j+1][0]);
                    String tmpo = arreglo[j+1][1];
                    
                    arreglo[j+1][0] = arreglo[j][0];
                    arreglo[j+1][1] = arreglo[j][1];
                    
                    arreglo[j][0] = String.valueOf(tmp);
                    arreglo[j][1] = tmpo;
                }
            }
        }
        return arreglo;
    }
    
    public String[][] burbuja2(String arreglo[][]){
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (Double.parseDouble(arreglo[j][2]) < Double.parseDouble(arreglo[j + 1][2])){
                    int tmp = Integer.parseInt(arreglo[j+1][2]);
                    String tmpo = arreglo[j+1][1];
                    String temp = arreglo[j+1][0];
                    
                    arreglo[j+1][2] = arreglo[j][2];
                    arreglo[j+1][1] = arreglo[j][1];
                    arreglo[j+1][0] = arreglo[j][0];
                    
                    arreglo[j][2] = String.valueOf(tmp);
                    arreglo[j][1] = tmpo;
                    arreglo[j][0] = String.valueOf(temp);
                }
            }
        }
        return arreglo;
    }
    
}
