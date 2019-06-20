package com.christianecg.interfaz.pizzeriaknn;

import com.christianecg.dato.pizzeriaknn.Persona;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author christianecg
 */
public interface InterfacePersona {
    public void Guardar(Persona persona);
    public String[][] Leer(int edad, int sexo);
    public DefaultTableModel listar();
}
