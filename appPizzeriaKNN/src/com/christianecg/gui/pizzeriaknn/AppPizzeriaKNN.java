package com.christianecg.gui.pizzeriaknn;

import javax.swing.JFrame;

/**
 *
 * @author christianecg
 */
public class AppPizzeriaKNN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame GuardaPreferencias = new Frm_GuardaPreferenciasPersona();
        GuardaPreferencias.setLocationRelativeTo(GuardaPreferencias);
        GuardaPreferencias.setVisible(true);
    }
    
}
